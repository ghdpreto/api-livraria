package br.com.ghdpreto.api_livraria.modules.pedidos.domain.repository;

import java.util.Optional;
import java.util.UUID;

import br.com.ghdpreto.api_livraria.modules.pedidos.domain.Pedido;

public interface IPedidoRepository {
    Pedido criar(Pedido pedido);

    Optional<Pedido> listarPorId(UUID id);
}
