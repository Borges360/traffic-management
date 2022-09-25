package br.anhembi.tcc.trafficmanagement.service;

import br.anhembi.tcc.trafficmanagement.dto.SemaforoImputDTO;
import br.anhembi.tcc.trafficmanagement.dto.SemaforoOutputDTO;
import br.anhembi.tcc.trafficmanagement.model.SemaforoModel;

public interface SemaforoSecundarioService {

    SemaforoOutputDTO criar(SemaforoImputDTO semaforoImputDTO, SemaforoModel semaforoModel);

}
