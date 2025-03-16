package br.com.ghdpreto.api_livraria.modules.livro.application.usecase;

import java.util.UUID;

import org.springframework.stereotype.Service;
import br.com.ghdpreto.api_livraria.modules.livro.domain.model.Livro;
import br.com.ghdpreto.api_livraria.modules.livro.domain.repository.ILivroRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuscarLivroPorIdUseCase {

    private final ILivroRepository repository;

    public Livro execute(UUID id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Livro com o ID [" + "] não encontrado."));

    }
}
