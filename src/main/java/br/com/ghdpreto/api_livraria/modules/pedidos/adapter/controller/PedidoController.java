package br.com.ghdpreto.api_livraria.modules.pedidos.adapter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ghdpreto.api_livraria.modules.pedidos.adapter.controller.dtos.RequestPedidoDTO;
import br.com.ghdpreto.api_livraria.modules.pedidos.application.usecase.CadastrarPedidoUseCase;
import br.com.ghdpreto.api_livraria.modules.pedidos.application.usecase.ListarPedidoUseCase;
import br.com.ghdpreto.api_livraria.modules.pedidos.domain.Pedido;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final CadastrarPedidoUseCase cadastrarPedidoUseCase;
    private final ListarPedidoUseCase listarPedidoUseCase;

    @PostMapping
    public ResponseEntity<UUID> cadastrar(@RequestBody RequestPedidoDTO dto) {

        UUID idPedido = cadastrarPedidoUseCase.execute(dto.idCliente(), dto.livros());

        return ResponseEntity.ok().body(idPedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> listarPorId(@PathVariable UUID id) {

        return ResponseEntity.ok().body(listarPedidoUseCase.execute(id));

    }

}
