package br.com.ghdpreto.api_livraria.modules.cliente.application.usecase;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.ghdpreto.api_livraria.modules.cliente.domain.model.Cliente;
import br.com.ghdpreto.api_livraria.modules.cliente.domain.repository.IClienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuscarClientePorIdUseCase {

    private final IClienteRepository repository;

    public Cliente execute(UUID id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente com o ID [" + id + "] não encontrado."));
    }
}
