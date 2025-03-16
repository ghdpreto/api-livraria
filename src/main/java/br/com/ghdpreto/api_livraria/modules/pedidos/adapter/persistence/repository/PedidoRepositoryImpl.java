package br.com.ghdpreto.api_livraria.modules.pedidos.adapter.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.ghdpreto.api_livraria.modules.pedidos.domain.Pedido;
import br.com.ghdpreto.api_livraria.modules.pedidos.domain.repository.IPedidoRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PedidoRepositoryImpl implements IPedidoRepository {

    private final JpaPedidoRepository repository;

    @Override
    public Pedido criar(Pedido pedido) {
        return repository.save(pedido);
    }

    @Override
    public Optional<Pedido> listarPorId(UUID id) {
        return repository.findById(id);
    }

}
