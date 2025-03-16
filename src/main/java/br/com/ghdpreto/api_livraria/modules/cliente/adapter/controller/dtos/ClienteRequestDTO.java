package br.com.ghdpreto.api_livraria.modules.cliente.adapter.controller.dtos;

import br.com.ghdpreto.api_livraria.modules.cliente.application.usecase.dtos.CadastrarClienteDTO;

public record ClienteRequestDTO(
        String nome,
        String email,
        String endereco) {

    public CadastrarClienteDTO paraUseCase() {
        return CadastrarClienteDTO.builder()
                .nome(nome)
                .email(email)
                .endereco(endereco)
                .build();
    }

}
