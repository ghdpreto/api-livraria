package br.com.ghdpreto.api_livraria.modules.livro.adapter.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.support.PageableUtils;
import org.springframework.stereotype.Repository;

import br.com.ghdpreto.api_livraria.common.dto.PaginaDTO;
import br.com.ghdpreto.api_livraria.common.dto.PaginacaoDTO;
import br.com.ghdpreto.api_livraria.modules.livro.domain.model.Livro;
import br.com.ghdpreto.api_livraria.modules.livro.domain.repository.ILivroRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LivroRepositoryImpl implements ILivroRepository {

    private final JpaLivroRepository repository;

    @Override
    public Livro cadastrar(Livro livro) {
        return repository.save(livro);
    }

    @Override
    public PaginaDTO<Livro> listar(PaginacaoDTO paginacao) {
        Page<Livro> page = this.repository.findAll(PageRequest.of(paginacao.pagina(), paginacao.tamanho()));

        return new PaginaDTO<Livro>(page.getContent(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages());
    }

    @Override
    public Optional<Livro> buscarPorId(UUID id) {
        return this.repository.findById(id);
    }

    @Override
    public Livro atualizar(Livro livro) {
        return repository.save(livro);
    }

}
