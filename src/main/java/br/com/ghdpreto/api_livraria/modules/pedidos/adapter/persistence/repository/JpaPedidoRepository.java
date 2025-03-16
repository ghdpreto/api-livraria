package br.com.ghdpreto.api_livraria.modules.pedidos.adapter.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ghdpreto.api_livraria.modules.pedidos.domain.Pedido;

public interface JpaPedidoRepository extends JpaRepository<Pedido, UUID> {

}
