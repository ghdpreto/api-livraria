package br.com.ghdpreto.api_livraria.modules.livro.adapter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ghdpreto.api_livraria.common.dto.PaginaDTO;
import br.com.ghdpreto.api_livraria.common.dto.PaginacaoDTO;
import br.com.ghdpreto.api_livraria.modules.livro.adapter.controller.dto.LivroRequestDTO;
import br.com.ghdpreto.api_livraria.modules.livro.adapter.controller.dto.LivroResponseDTO;
import br.com.ghdpreto.api_livraria.modules.livro.application.usecase.BuscarLivroPorIdUseCase;
import br.com.ghdpreto.api_livraria.modules.livro.application.usecase.CadastrarLivroUseCase;
import br.com.ghdpreto.api_livraria.modules.livro.application.usecase.ListarLivrosUseCase;
import br.com.ghdpreto.api_livraria.modules.livro.domain.model.Livro;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    private final CadastrarLivroUseCase cadastrarLivroUseCase;
    private final BuscarLivroPorIdUseCase buscarLivroPorIdUseCase;
    private final ListarLivrosUseCase listarLivrosUseCase;

    @PostMapping
    public ResponseEntity<LivroResponseDTO> cadastrar(@RequestBody LivroRequestDTO dto) {
        Livro livro = cadastrarLivroUseCase.execute(dto.paraUseCase());
        return ResponseEntity.ok().body(LivroResponseDTO.paraDto(livro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> buscarPorId(@PathVariable UUID id) {
        Livro livro = buscarLivroPorIdUseCase.execute(id);
        return ResponseEntity.ok().body(LivroResponseDTO.paraDto(livro));
    }

    @GetMapping
    public ResponseEntity<PaginaDTO<LivroResponseDTO>> listar(@ModelAttribute PaginacaoDTO dto) {
        PaginaDTO<Livro> livros = listarLivrosUseCase.execute(dto);

        List<LivroResponseDTO> livroConteudo = livros.conteudo().stream().map(LivroResponseDTO::paraDto).toList();

        return ResponseEntity.ok().body(PaginaDTO.<LivroResponseDTO>builder()
                .conteudo(livroConteudo)
                .paginaAtual(livros.paginaAtual())
                .tamanhoPagina(livros.tamanhoPagina())
                .totalElementos(livros.totalElementos())
                .totalPaginas(livros.totalPaginas())
                .build());
    }

}
