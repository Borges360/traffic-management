package br.anhembi.tcc.trafficmanagement.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "\"semaforo_secundarios\"")
public class Secundarios {


    @ManyToOne
    @JoinColumn(name="semaforo_id", nullable=false)
    private SemaforoModel id;

    @Column(name = "idSemaforoSecondario")
    private Long idSemaforoSecondario;

    @Column(name = "tempoInverso")
    private boolean tempoInverso;

    @Id
    private String idSecundario = UUID.randomUUID().toString();


    public Secundarios(SemaforoModel semaforoModel, Long idSemaforoSecondario, boolean tempoInverso) {
        this.id = semaforoModel;
        this.idSemaforoSecondario = idSemaforoSecondario;
        this.tempoInverso = tempoInverso;
    }

    public Secundarios() {

    }
}
