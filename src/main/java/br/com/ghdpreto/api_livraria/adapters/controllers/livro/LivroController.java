package br.com.ghdpreto.api_livraria.adapters.controllers.livro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ghdpreto.api_livraria.adapters.controllers.livro.dtos.LivroResponseDTO;
import br.com.ghdpreto.api_livraria.adapters.controllers.livro.dtos.PaginaResponseDTO;
import br.com.ghdpreto.api_livraria.adapters.controllers.livro.dtos.PaginacaoRequestDTO;
import br.com.ghdpreto.api_livraria.application.livro.CadastrarLivroUseCase;
import br.com.ghdpreto.api_livraria.application.livro.ListarLivroPorIdUseCase;
import br.com.ghdpreto.api_livraria.application.livro.ListarLivroUseCase;
import br.com.ghdpreto.api_livraria.application.livro.dtos.CadastrarLivroDTO;
import br.com.ghdpreto.api_livraria.application.livro.dtos.PaginaDTO;
import br.com.ghdpreto.api_livraria.domain.entities.Livro;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    private final CadastrarLivroUseCase cadastrarLivroUseCase;
    private final ListarLivroPorIdUseCase listarLivroPorIdUseCase;
    private final ListarLivroUseCase listarLivroUseCase;

    @PostMapping
    public ResponseEntity<LivroResponseDTO> cadastrar(@RequestBody CadastrarLivroDTO dto) {
        Livro livro = cadastrarLivroUseCase.execute(dto);
        return ResponseEntity.ok().body(LivroResponseDTO.paraDto(livro));
    }

    @GetMapping
    public ResponseEntity<PaginaResponseDTO<LivroResponseDTO>> getMethodName(@ModelAttribute PaginacaoRequestDTO dto) {

        PaginaDTO<Livro> livros = listarLivroUseCase.execute(dto.paraDomain());

        List<LivroResponseDTO> conteudo = livros.conteudo().stream().map(LivroResponseDTO::paraDto).toList();

        return ResponseEntity.ok()
                .body(new PaginaResponseDTO<LivroResponseDTO>(conteudo, livros.paginaAtual(), livros.tamanhoPagina(),
                        livros.totalElementos(), livros.totalPaginas()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> buscarPorId(@PathVariable UUID id) {
        Livro livro = listarLivroPorIdUseCase.execute(id);
        return ResponseEntity.ok().body(LivroResponseDTO.paraDto(livro));
    }

}
