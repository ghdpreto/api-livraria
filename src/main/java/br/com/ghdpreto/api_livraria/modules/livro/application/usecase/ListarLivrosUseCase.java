package br.com.ghdpreto.api_livraria.modules.livro.application.usecase;

import org.springframework.stereotype.Service;

import br.com.ghdpreto.api_livraria.common.dto.PaginaDTO;
import br.com.ghdpreto.api_livraria.common.dto.PaginacaoDTO;
import br.com.ghdpreto.api_livraria.modules.livro.domain.model.Livro;
import br.com.ghdpreto.api_livraria.modules.livro.domain.repository.ILivroRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListarLivrosUseCase {

    private final ILivroRepository repository;

    public PaginaDTO<Livro> execute(PaginacaoDTO paginacao) {
        return repository.listar(paginacao);
    }

}
