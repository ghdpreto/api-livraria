package br.com.ghdpreto.api_livraria.modules.pedidos.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.ghdpreto.api_livraria.modules.cliente.domain.model.Cliente;
import br.com.ghdpreto.api_livraria.modules.livro.domain.model.Livro;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pedidos")
@AllArgsConstructor(access = AccessLevel.MODULE)
@NoArgsConstructor(access = AccessLevel.MODULE)
@Builder(toBuilder = true)
@Getter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "dt_criacao", nullable = false, updatable = false)
    @Setter(AccessLevel.NONE)
    private LocalDateTime dataCriacao;

    @Column(name = "dt_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "pedido_livro", // NOME DA TABELA DE RELACIONAMENTO
            joinColumns = @JoinColumn(name = "id_pedido"), // ID DA CLASSE PEDIDO
            inverseJoinColumns = @JoinColumn(name = "id_livro") // ID DA CLASSE LIVRO
    )
    @JsonManagedReference
    private List<Livro> livros;

    @PrePersist
    protected void aoCriar() {
        dataCriacao = LocalDateTime.now();
        dataAtualizacao = LocalDateTime.now();
    }

    @PreUpdate
    protected void aoAtualizar() {
        dataAtualizacao = LocalDateTime.now();
    }
}
