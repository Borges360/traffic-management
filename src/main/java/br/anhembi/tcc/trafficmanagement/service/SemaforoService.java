package br.anhembi.tcc.trafficmanagement.service;

import br.anhembi.tcc.trafficmanagement.dto.SemaforoImputDTO;
import br.anhembi.tcc.trafficmanagement.dto.SemaforoOutputDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SemaforoService {

    SemaforoOutputDTO criar(SemaforoImputDTO semaforoImputDTO);

    Integer deletar(String identificador);

    Page<SemaforoOutputDTO> buscarSemaforos(Pageable pageable);

    SemaforoOutputDTO buscarSemaforo(String identificador);

    Integer iniciarSemaforo(String identificador);
}
