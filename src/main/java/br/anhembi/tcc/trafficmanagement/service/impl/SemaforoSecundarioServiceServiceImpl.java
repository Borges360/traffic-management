package br.anhembi.tcc.trafficmanagement.service.impl;

import br.anhembi.tcc.trafficmanagement.dto.SemaforoImputDTO;
import br.anhembi.tcc.trafficmanagement.dto.SemaforoOutputDTO;
import br.anhembi.tcc.trafficmanagement.exception.SemaforoNaoEncontradoException;
import br.anhembi.tcc.trafficmanagement.mapper.SemaforoMapper;
import br.anhembi.tcc.trafficmanagement.model.Secundarios;
import br.anhembi.tcc.trafficmanagement.model.SemaforoModel;
import br.anhembi.tcc.trafficmanagement.repository.SemaforoRepository;
import br.anhembi.tcc.trafficmanagement.service.SemaforoSecundarioService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SemaforoSecundarioServiceServiceImpl implements SemaforoSecundarioService {

    private final SemaforoRepository semaforoRepository;
    private final SemaforoMapper semaforoMapper;

    public SemaforoSecundarioServiceServiceImpl(SemaforoRepository semaforoRepository, SemaforoMapper semaforoMapper) {
        this.semaforoRepository = semaforoRepository;
        this.semaforoMapper = semaforoMapper;
    }


    public SemaforoOutputDTO criar(SemaforoImputDTO semaforoImputDTO, SemaforoModel semaforoModel) {

        Optional<SemaforoModel> semaforoPrincipal = semaforoRepository.findByIdentificador(semaforoImputDTO.getIdentificadorSemaforoPrincipal());

        if (semaforoPrincipal.isPresent()) {
            List<Secundarios> listaSecundarios = semaforoPrincipal.get().getSecundarios();
            listaSecundarios.add(new Secundarios(semaforoPrincipal.get(), semaforoModel.getId(), semaforoImputDTO.isTempoInverso()));
            semaforoRepository.save(semaforoPrincipal.get());

            if (semaforoImputDTO.isTempoInverso()){
                inverterTempo(semaforoModel, semaforoPrincipal);
                semaforoRepository.save(semaforoModel);
            }

            return semaforoMapper.toOutputDTO(semaforoModel);
        }
        throw new SemaforoNaoEncontradoException(semaforoImputDTO.getIdentificadorSemaforoPrincipal());

    }

    private void inverterTempo(SemaforoModel semaforoModel, Optional<SemaforoModel> semaforoPrincipal) {

        if (semaforoPrincipal.isPresent()) {
            semaforoModel.setTempoVerde(semaforoPrincipal.get().getTempoVermelho());
            semaforoModel.setTempoVermelho(semaforoPrincipal.get().getTempoVerde());
            semaforoModel.setTempoAmarelo(semaforoPrincipal.get().getTempoAmarelo());
        }

    }
}

