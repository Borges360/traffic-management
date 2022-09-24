package br.anhembi.tcc.trafficmanagement.dto;

import br.anhembi.tcc.trafficmanagement.model.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SemaforoOutputDTO {

    private Long id;

    private String identificador;

    private long tempoVermelho;

    private long tempoAmarelo;

    private long tempoVerde;

    private Status status;

}
