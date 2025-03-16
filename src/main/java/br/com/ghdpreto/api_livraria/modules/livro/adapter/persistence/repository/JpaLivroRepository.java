package br.com.ghdpreto.api_livraria.modules.livro.adapter.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ghdpreto.api_livraria.modules.livro.domain.model.Livro;

public interface JpaLivroRepository extends JpaRepository<Livro, UUID> {

}
