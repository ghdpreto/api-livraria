package br.com.ghdpreto.api_livraria.modules.cliente.adapter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ghdpreto.api_livraria.modules.cliente.adapter.controller.dtos.ClienteAtualizarRequestDTO;
import br.com.ghdpreto.api_livraria.modules.cliente.adapter.controller.dtos.ClienteRequestDTO;
import br.com.ghdpreto.api_livraria.modules.cliente.adapter.controller.dtos.ClienteResponseDTO;
import br.com.ghdpreto.api_livraria.modules.cliente.application.usecase.AtualizarClienteUseCase;
import br.com.ghdpreto.api_livraria.modules.cliente.application.usecase.BuscarClientePorIdUseCase;
import br.com.ghdpreto.api_livraria.modules.cliente.application.usecase.CadastrarClienteUseCase;
import br.com.ghdpreto.api_livraria.modules.cliente.application.usecase.DeletarClienteUseCase;
import br.com.ghdpreto.api_livraria.modules.cliente.domain.model.Cliente;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final CadastrarClienteUseCase cadastrarClienteUseCase;
    private final AtualizarClienteUseCase atualizarClienteUseCase;
    private final BuscarClientePorIdUseCase buscarClientePorIdUseCase;
    private final DeletarClienteUseCase deletarClienteUseCase;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> cadastrar(@RequestBody ClienteRequestDTO dto) {
        Cliente cliente = cadastrarClienteUseCase.execute(dto.paraUseCase());
        return ResponseEntity.ok().body(ClienteResponseDTO.paraDto(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable UUID id, @RequestBody ClienteAtualizarRequestDTO dto) {
        atualizarClienteUseCase.execute(id, dto.paraUseCase());
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable UUID id) {
        Cliente cliente = buscarClientePorIdUseCase.execute(id);
        return ResponseEntity.ok().body(ClienteResponseDTO.paraDto(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable UUID id) {
        deletarClienteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

}
