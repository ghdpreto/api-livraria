package br.com.ghdpreto.api_livraria.modules.pedidos.application.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ghdpreto.api_livraria.modules.cliente.application.usecase.BuscarClientePorIdUseCase;
import br.com.ghdpreto.api_livraria.modules.cliente.domain.model.Cliente;
import br.com.ghdpreto.api_livraria.modules.livro.application.usecase.AtualizarSaldoLivroUseCase;
import br.com.ghdpreto.api_livraria.modules.livro.application.usecase.BuscarLivroPorIdUseCase;
import br.com.ghdpreto.api_livraria.modules.livro.domain.model.Livro;
import br.com.ghdpreto.api_livraria.modules.pedidos.domain.Pedido;
import br.com.ghdpreto.api_livraria.modules.pedidos.domain.repository.IPedidoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CadastrarPedidoUseCase {

    private final IPedidoRepository repository;
    private final BuscarClientePorIdUseCase buscarClientePorIdUseCase;
    private final BuscarLivroPorIdUseCase buscarLivroPorIdUseCase;
    private final AtualizarSaldoLivroUseCase atualizarSaldoLivroUseCase;

    public UUID execute(UUID idCliente, List<UUID> idLivros) {
        List<Livro> livros = new ArrayList<>();

        // validar o cliente
        Cliente cliente = buscarClientePorIdUseCase.execute(idCliente);

        // validar se os livros tem saldo disponivel
        idLivros.stream()
                // agrupa por id
                .collect(Collectors.groupingBy(livroId -> livroId, Collectors.counting()))
                // valida se tem saldo
                // valida se o livro existe
                .forEach((livroId, quantidadePedido) -> {
                    Livro livro = buscarLivroPorIdUseCase.execute(livroId);

                    if (livro.getQuantidadeEstoque() < quantidadePedido) {
                        throw new RuntimeException("Saldo insuficiente para o livro com ID: " + livroId);
                    }

                    livros.add(livro);

                    // atualiza o saldo na base
                    atualizarSaldoLivroUseCase.execute(livroId, quantidadePedido.intValue());

                });

        Pedido novoPedido = Pedido.builder()
                .cliente(cliente)
                .livros(livros)
                .build();

        // persiste o pedido
        return repository.criar(novoPedido).getId();

    }
}
