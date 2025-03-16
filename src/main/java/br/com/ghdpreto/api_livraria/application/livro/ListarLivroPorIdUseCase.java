package br.com.ghdpreto.api_livraria.application.livro;

import java.util.UUID;

import br.com.ghdpreto.api_livraria.application.livro.exceptions.NaoEncontradoException;
import br.com.ghdpreto.api_livraria.domain.entities.Livro;
import br.com.ghdpreto.api_livraria.domain.repositories.LivroRepository;

public class ListarLivroPorIdUseCase {

    private final LivroRepository repository;

    public ListarLivroPorIdUseCase(LivroRepository repository) {
        this.repository = repository;
    }

    public Livro execute(UUID id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new NaoEncontradoException("Livro com ID [" + id + "] não foi encontrado."));
    }
}
