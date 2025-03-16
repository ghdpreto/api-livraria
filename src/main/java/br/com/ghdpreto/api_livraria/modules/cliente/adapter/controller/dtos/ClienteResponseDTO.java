package br.com.ghdpreto.api_livraria.modules.cliente.adapter.controller.dtos;

import java.util.UUID;

import br.com.ghdpreto.api_livraria.modules.cliente.domain.model.Cliente;
import lombok.Builder;

@Builder
public record ClienteResponseDTO(
        UUID id,
        String nome,
        String email,
        String endereco) {

    public static ClienteResponseDTO paraDto(Cliente cliente) {
        return ClienteResponseDTO.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .endereco(cliente.getEndereco())
                .build();
    }
}
