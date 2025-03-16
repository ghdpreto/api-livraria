package br.com.ghdpreto.api_livraria.modules.cliente.application.usecase.dtos;

import lombok.Builder;

@Builder
public record AtualizarClienteDTO(
        String nome,
        String endereco) {

}
