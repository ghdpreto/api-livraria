package br.com.ghdpreto.api_livraria.modules.cliente.application.usecase;

import org.springframework.stereotype.Service;

import br.com.ghdpreto.api_livraria.modules.cliente.application.usecase.dtos.CadastrarClienteDTO;
import br.com.ghdpreto.api_livraria.modules.cliente.domain.model.Cliente;
import br.com.ghdpreto.api_livraria.modules.cliente.domain.repository.IClienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastrarClienteUseCase {

    private final IClienteRepository repository;

    public Cliente execute(CadastrarClienteDTO dto) {

        // validar se o email ja esta cadastrado
        if (repository.buscarPorEmail(dto.email()).isPresent()) {
            throw new RuntimeException("Cliente com o EMAIL [" + dto.email() + "] ja cadastrado.");
        }

        return repository.cadastrar(dto.paraEntidade());
    }
}
