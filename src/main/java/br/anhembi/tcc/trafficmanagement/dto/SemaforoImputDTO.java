package br.anhembi.tcc.trafficmanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SemaforoImputDTO {

    private String identificador;

    private String identificadorSemaforoPrincipal;

    private boolean tempoInverso;

}
