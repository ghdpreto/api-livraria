package br.com.ghdpreto.api_livraria.adapters.repositories.livro;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ghdpreto.api_livraria.frameworks.database.entities.LivroEntity;

public interface SpringDataLivroRepository extends JpaRepository<LivroEntity, UUID> {

}
