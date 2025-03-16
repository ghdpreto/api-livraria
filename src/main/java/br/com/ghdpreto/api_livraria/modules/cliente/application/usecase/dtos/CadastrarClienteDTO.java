package br.com.ghdpreto.api_livraria.modules.cliente.application.usecase.dtos;

import br.com.ghdpreto.api_livraria.modules.cliente.domain.model.Cliente;
import lombok.Builder;

@Builder
public record CadastrarClienteDTO(
        String nome,
        String endereco,
        String email) {

    public Cliente paraEntidade() {
        return Cliente.builder()
                .email(email)
                .nome(nome)
                .endereco(endereco)
                .build();
    }

}
