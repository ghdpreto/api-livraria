package br.com.ghdpreto.api_livraria.domain.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "livro")
@AllArgsConstructor(access = AccessLevel.MODULE)
@NoArgsConstructor(access = AccessLevel.MODULE)
@Builder(toBuilder = true)
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ds_titulo", nullable = false)
    private String titulo;

    @Column(name = "ds_author", nullable = false)
    private String autor;

    @Column(name = "vl_preco", nullable = false)
    private Double preco;

    @Column(name = "qt_estoque")
    private Integer quantidadeEstoque;
}
