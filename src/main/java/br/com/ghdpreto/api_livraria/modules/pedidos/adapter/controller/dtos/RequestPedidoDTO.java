package br.com.ghdpreto.api_livraria.modules.pedidos.adapter.controller.dtos;

import java.util.List;
import java.util.UUID;

public record RequestPedidoDTO(
        UUID idCliente,
        List<UUID> livros) {
}
