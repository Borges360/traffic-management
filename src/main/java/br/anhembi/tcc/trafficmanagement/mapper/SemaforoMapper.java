package br.anhembi.tcc.trafficmanagement.mapper;

import br.anhembi.tcc.trafficmanagement.dto.SemaforoImputDTO;
import br.anhembi.tcc.trafficmanagement.dto.SemaforoOutputDTO;
import br.anhembi.tcc.trafficmanagement.model.SemaforoModel;
import org.springframework.stereotype.Component;

@Component
public class SemaforoMapper {

    public SemaforoModel toModel(SemaforoImputDTO semaforoImputDTO){
        return SemaforoModel.builder()
                .identificador(semaforoImputDTO.getIdentificador())

                .build();
    }

    public SemaforoOutputDTO toOutputDTO(SemaforoModel semaforoModel){
        return SemaforoOutputDTO.builder()
                .id(semaforoModel.getId())
                .identificador(semaforoModel.getIdentificador())
                .tempoAmarelo(semaforoModel.getTempoAmarelo())
                .tempoVerde(semaforoModel.getTempoVerde())
                .tempoVermelho(semaforoModel.getTempoVermelho())
                .status(semaforoModel.getStatus())
                .build();
    }
}
