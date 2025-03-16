package br.com.ghdpreto.api_livraria.modules.cliente.adapter.controller.dtos;

import br.com.ghdpreto.api_livraria.modules.cliente.application.usecase.dtos.AtualizarClienteDTO;

public record ClienteAtualizarRequestDTO(
        String nome,
        String endereco) {

    public AtualizarClienteDTO paraUseCase() {
        return AtualizarClienteDTO.builder()
                .nome(nome)
                .endereco(endereco)
                .build();
    }

}