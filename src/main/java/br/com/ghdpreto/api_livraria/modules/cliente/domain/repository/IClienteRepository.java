package br.com.ghdpreto.api_livraria.modules.cliente.domain.repository;

import java.util.Optional;

import br.com.ghdpreto.api_livraria.modules.cliente.domain.model.Cliente;

public interface IClienteRepository {
    Cliente cadastrar(Cliente cliente);

    Optional<Cliente> buscarPorEmail(String email);
}
