package br.com.ghdpreto.api_livraria.modules.pedidos.application.usecase;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.ghdpreto.api_livraria.modules.pedidos.domain.Pedido;
import br.com.ghdpreto.api_livraria.modules.pedidos.domain.repository.IPedidoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListarPedidoUseCase {

    private final IPedidoRepository repository;

    public Pedido execute(UUID id) {
        return repository.listarPorId(id)
                .orElseThrow(() -> new RuntimeException("Pedido com o ID [" + id + "] não encontrado."));
    }
}
