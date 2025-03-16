package br.com.ghdpreto.api_livraria.modules.cliente.application.usecase;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.ghdpreto.api_livraria.modules.cliente.domain.repository.IClienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeletarClienteUseCase {

    private final IClienteRepository repository;
    private final BuscarClientePorIdUseCase buscarClientePorIdUseCase;

    public void execute(UUID id) {

        buscarClientePorIdUseCase.execute(id);

        repository.deletar(id);
    }
}
