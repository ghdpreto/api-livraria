package br.com.ghdpreto.api_livraria.frameworks.database.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.ghdpreto.api_livraria.domain.entities.Livro;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "livro")
@AllArgsConstructor(access = AccessLevel.MODULE)
@NoArgsConstructor(access = AccessLevel.MODULE)
@Builder(toBuilder = true)
@Getter
public class LivroEntity {

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

    @Column(name = "dt_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;

    public static Livro paraDominio(LivroEntity entity) {
        return Livro.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .autor(entity.getAutor())
                .preco(entity.getPreco())
                .quantidadeEstoque(entity.getQuantidadeEstoque())
                .dataAtualizacao(entity.getDataAtualizacao())
                .dataCriacao(entity.getDataCriacao())
                .build();
    }

    public static LivroEntity paraEntity(Livro livro) {
        return LivroEntity.builder()
                .id(livro.getId())
                .titulo(livro.getTitulo())
                .autor(livro.getAutor())
                .preco(livro.getPreco())
                .quantidadeEstoque(livro.getQuantidadeEstoque())
                .dataAtualizacao(livro.getDataAtualizacao())
                .dataCriacao(livro.getDataCriacao())
                .build();

    }
}
