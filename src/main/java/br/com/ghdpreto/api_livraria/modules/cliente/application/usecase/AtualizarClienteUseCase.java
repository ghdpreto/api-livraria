package br.com.ghdpreto.api_livraria.modules.cliente.application.usecase;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.ghdpreto.api_livraria.modules.cliente.application.usecase.dtos.AtualizarClienteDTO;
import br.com.ghdpreto.api_livraria.modules.cliente.domain.model.Cliente;
import br.com.ghdpreto.api_livraria.modules.cliente.domain.repository.IClienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtualizarClienteUseCase {

    private final IClienteRepository repository;

    public Cliente execute(UUID id, AtualizarClienteDTO dto) {
        // validar se existe
        Cliente cliente = repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente com o ID [" + id + "] não encontrado."));

        // atualiza os campos que foram enviados
        Cliente clienteAtualizado = cliente.toBuilder()
                .nome(dto.nome() != null ? dto.nome() : cliente.getNome())
                .endereco(dto.endereco() != null ? dto.endereco() : cliente.getEndereco())
                .build();

        // persiste
        return repository.atualizar(clienteAtualizado);
    }
}
