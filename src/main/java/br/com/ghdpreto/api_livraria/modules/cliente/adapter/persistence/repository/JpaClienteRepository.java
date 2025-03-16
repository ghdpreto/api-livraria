package br.com.ghdpreto.api_livraria.modules.cliente.adapter.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ghdpreto.api_livraria.modules.cliente.domain.model.Cliente;

public interface JpaClienteRepository extends JpaRepository<Cliente, UUID> {

    Optional<Cliente> findByEmail(String email);

}
