package br.com.ghdpreto.api_livraria.domain.repositories;

import java.util.Optional;
import java.util.UUID;

import br.com.ghdpreto.api_livraria.application.livro.dtos.PaginaDTO;
import br.com.ghdpreto.api_livraria.application.livro.dtos.PaginacaoDTO;
import br.com.ghdpreto.api_livraria.domain.entities.Livro;

public interface LivroRepository {

    Livro cadastrar(Livro livro);

    PaginaDTO<Livro> listar(PaginacaoDTO paginacao);

    Optional<Livro> buscarPorId(UUID id);
}
