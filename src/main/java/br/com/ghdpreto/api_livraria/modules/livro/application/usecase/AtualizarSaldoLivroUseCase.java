package br.com.ghdpreto.api_livraria.modules.livro.application.usecase;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.ghdpreto.api_livraria.modules.livro.domain.model.Livro;
import br.com.ghdpreto.api_livraria.modules.livro.domain.repository.ILivroRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtualizarSaldoLivroUseCase {

    private final ILivroRepository repository;
    private final BuscarLivroPorIdUseCase buscarLivroPorIdUseCase;

    public Livro execute(UUID id, Integer quantidade) {

        Livro livro = buscarLivroPorIdUseCase.execute(id);

        if (livro.getQuantidadeEstoque() < quantidade) {
            throw new RuntimeException(
                    "Saldo insuficiente ID[" + id + "] - Saldo atual: " + livro.getQuantidadeEstoque()
                            + ", quantidade solicitada: " + quantidade);
        }

        Integer novoSaldo = livro.getQuantidadeEstoque() - quantidade;

        Livro livroAtualizado = livro.toBuilder().quantidadeEstoque(novoSaldo).build();

        return repository.atualizar(livroAtualizado);

    }
}
