package br.com.ghdpreto.api_livraria.domain.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.MODULE)
@NoArgsConstructor(access = AccessLevel.MODULE)
@MappedSuperclass
public class Auditoria {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_criacao", nullable = false, updatable = false)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_atualizacao", nullable = false)
    private Date dataAtualizacao;

    @PrePersist
    protected void onCriar() {
        dataCriacao = new Date();
        dataAtualizacao = new Date();
    }

    @PreUpdate
    protected void onAtualizar() {
        dataAtualizacao = new Date();
    }
}
