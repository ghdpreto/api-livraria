package br.com.ghdpreto.api_livraria.modules.cliente.adapter.persistence.repository;

import br.com.ghdpreto.api_livraria.modules.cliente.domain.model.Cliente;
import br.com.ghdpreto.api_livraria.modules.cliente.domain.repository.IClienteRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ClienteRepositoryImpl implements IClienteRepository {

    private final JpaClienteRepository repository;

    @Override
    public Cliente cadastrar(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarPorId(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void deletar(UUID id) {
        repository.deleteById(id);
    }

}
