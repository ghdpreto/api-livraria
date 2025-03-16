package br.com.ghdpreto.api_livraria.application.livro;

import br.com.ghdpreto.api_livraria.application.livro.dtos.PaginaDTO;
import br.com.ghdpreto.api_livraria.application.livro.dtos.PaginacaoDTO;
import br.com.ghdpreto.api_livraria.domain.entities.Livro;
import br.com.ghdpreto.api_livraria.domain.repositories.LivroRepository;

public class ListarLivroUseCase {

    private final LivroRepository repository;

    public ListarLivroUseCase(LivroRepository repository) {
        this.repository = repository;
    }

    public PaginaDTO<Livro> execute(PaginacaoDTO paginacao) {
        return repository.listar(paginacao);
    }
}
