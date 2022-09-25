package br.anhembi.tcc.trafficmanagement.model;

import lombok.Getter;

@Getter
public enum TempoPadrao {

    SINAL_VERDE(500000L),
    SINAL_VERMELHO(300000L),
    SINAL_AMARELO(5000L),

    SINAL_VERDE_SECUNDARIO(SINAL_VERMELHO.getTempo()),
    SINAL_VERMELHO_SECUNDARIO(SINAL_VERDE.getTempo());

    private final Long tempo;

    TempoPadrao(Long tempo) {
        this.tempo = tempo;
    }

}
