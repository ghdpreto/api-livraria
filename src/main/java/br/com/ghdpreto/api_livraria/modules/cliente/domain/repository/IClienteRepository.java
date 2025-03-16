package br.com.ghdpreto.api_livraria.modules.cliente.domain.repository;

import java.util.Optional;
import java.util.UUID;

import br.com.ghdpreto.api_livraria.modules.cliente.domain.model.Cliente;

public interface IClienteRepository {
    Cliente cadastrar(Cliente cliente);

    Cliente atualizar(Cliente cliente);

    Optional<Cliente> buscarPorEmail(String email);

    Optional<Cliente> buscarPorId(UUID id);

    void deletar(UUID id);
}
