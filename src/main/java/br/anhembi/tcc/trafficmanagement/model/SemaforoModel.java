package br.anhembi.tcc.trafficmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@Table(name = "semaforo")
public class SemaforoModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identificador")
    private String identificador;

    @Builder.Default
    @Column(name = "tempoVermelho")
    private long tempoVermelho = TempoPadrao.SINAL_VERMELHO.getTempo();

    @Builder.Default
    @Column(name = "tempoAmarelo")
    private long tempoAmarelo = TempoPadrao.SINAL_AMARELO.getTempo();

    @Builder.Default
    @Column(name = "tempoVerde")
    private long tempoVerde = TempoPadrao.SINAL_VERDE.getTempo();

    @Builder.Default
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status = Status.PROCESSANDO;

    @Column(name = "url")
    private String url;

    @Column(name = "porta")
    private int porta;

    public SemaforoModel() {

    }
}
