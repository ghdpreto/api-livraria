package br.com.ghdpreto.api_livraria.adapters.repositories.livro;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import br.com.ghdpreto.api_livraria.application.livro.dtos.PaginaDTO;
import br.com.ghdpreto.api_livraria.application.livro.dtos.PaginacaoDTO;
import br.com.ghdpreto.api_livraria.domain.entities.Livro;
import br.com.ghdpreto.api_livraria.domain.repositories.LivroRepository;
import br.com.ghdpreto.api_livraria.frameworks.database.entities.LivroEntity;

@Repository
public class JpaLivroRepository implements LivroRepository {
    private final SpringDataLivroRepository repository;

    public JpaLivroRepository(SpringDataLivroRepository repository) {
        this.repository = repository;
    }

    @Override
    public Livro cadastrar(Livro livro) {
        LivroEntity entidade = LivroEntity.paraEntity(livro);
        LivroEntity entidadeSalva = repository.save(entidade);
        return LivroEntity.paraDominio(entidadeSalva);
    }

    @Override
    public Optional<Livro> buscarPorId(UUID id) {
        return repository.findById(id).map(LivroEntity::paraDominio);
    }

    @Override
    public PaginaDTO<Livro> listar(PaginacaoDTO paginacao) {

        PageRequest pageabel = PageRequest.of(paginacao.pagina(), paginacao.tamanho());

        Page<LivroEntity> page = repository.findAll(pageabel);

        List<Livro> conteudo = page.getContent().stream().map(LivroEntity::paraDominio).toList();

        return new PaginaDTO<Livro>(conteudo, page.getNumber(), page.getSize(), page.getTotalElements(),
                page.getTotalPages());
    }

}
