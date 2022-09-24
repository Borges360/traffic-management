package br.anhembi.tcc.trafficmanagement.model;

import lombok.Getter;

@Getter
public enum TempoPadrao {

    SINAL_VERDE(300000L),
    SINAL_VERMELHO(300000L),
    SINAL_AMARELO(5000L);

    private final Long tempo;

    TempoPadrao(Long tempo) {
        this.tempo = tempo;
    }

}
