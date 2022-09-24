package br.anhembi.tcc.trafficmanagement.model;

import lombok.Getter;

@Getter
public enum Status {

    ATIVO("ativo"),
    PROCESSANDO("processando"),
    INATIVO("inativo");

    private final String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }
}
