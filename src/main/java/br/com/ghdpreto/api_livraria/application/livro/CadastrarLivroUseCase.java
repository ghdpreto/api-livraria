package br.com.ghdpreto.api_livraria.application.livro;

import br.com.ghdpreto.api_livraria.application.livro.dtos.CadastrarLivroDTO;
import br.com.ghdpreto.api_livraria.domain.entities.Livro;
import br.com.ghdpreto.api_livraria.domain.repositories.LivroRepository;

public class CadastrarLivroUseCase {

    private final LivroRepository repository;

    public CadastrarLivroUseCase(LivroRepository repository) {
        this.repository = repository;
    }

    public Livro execute(CadastrarLivroDTO dto) {
        // aqui posso colocar algumas validacoes, ou tratamentos no dto
        Livro livro = dto.paraDominio();
        return repository.cadastrar(livro);
    }
}
