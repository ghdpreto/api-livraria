package br.com.ghdpreto.api_livraria.modules.cliente.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "clientes")
@AllArgsConstructor(access = AccessLevel.MODULE)
@NoArgsConstructor(access = AccessLevel.MODULE)
@Builder(toBuilder = true)
@Getter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ds_nome", nullable = false)
    private String nome;

    @Column(name = "ds_endereco")
    private String endereco;

    @Column(name = "ds_email", nullable = false, unique = true)
    private String email;

    @Column(name = "dt_criacao", nullable = false, updatable = false)
    @Setter(AccessLevel.NONE)
    private LocalDateTime dataCriacao;

    @Column(name = "dt_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;

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
