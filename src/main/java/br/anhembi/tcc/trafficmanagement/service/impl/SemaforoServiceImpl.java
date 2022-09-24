package br.anhembi.tcc.trafficmanagement.service.impl;

import br.anhembi.tcc.trafficmanagement.dto.SemaforoImputDTO;
import br.anhembi.tcc.trafficmanagement.dto.SemaforoOutputDTO;
import br.anhembi.tcc.trafficmanagement.exception.SemaforoNaoEncontradoException;
import br.anhembi.tcc.trafficmanagement.mapper.SemaforoMapper;
import br.anhembi.tcc.trafficmanagement.model.SemaforoModel;
import br.anhembi.tcc.trafficmanagement.model.Status;
import br.anhembi.tcc.trafficmanagement.repository.SemaforoRepository;
import br.anhembi.tcc.trafficmanagement.service.SemaforoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SemaforoServiceImpl implements SemaforoService {

    private final SemaforoRepository semaforoRepository;
    private final SemaforoMapper semaforoMapper;

    public SemaforoServiceImpl(SemaforoRepository semaforoRepository, SemaforoMapper semaforoMapper) {
        this.semaforoRepository = semaforoRepository;
        this.semaforoMapper = semaforoMapper;
    }

    public Page<SemaforoOutputDTO> buscarSemaforos(Pageable pageable) {

        Optional<Page<SemaforoModel>> semaforoModelPage = Optional.of(semaforoRepository.findAll(pageable));

        return semaforoModelPage.map(semaforoModelsPages ->
                semaforoModelsPages.map(semaforoMapper::toOutputDTO) ).get();

    }

    public SemaforoOutputDTO buscarSemaforo(String identificador) {
        final Optional<SemaforoModel> semaforo = semaforoRepository.findByIdentificador(identificador);

        if (semaforo.isPresent()) {
            return semaforoMapper.toOutputDTO(semaforo.get());
        } else {
            throw new SemaforoNaoEncontradoException(identificador);
        }

    }

    public SemaforoOutputDTO criar(SemaforoImputDTO semaforoImputDTO, String url, int porta) {

        final SemaforoModel semaforoModel = semaforoMapper.toModel(semaforoImputDTO, url, porta);
        return semaforoMapper.toOutputDTO(semaforoRepository.save(semaforoModel));

    }

    public Integer deletar(String identificador) {

        Integer quantidadeExclusoes  = semaforoRepository.deleteByIdentificador(identificador);

        if(quantidadeExclusoes>0){
            return quantidadeExclusoes;
        } else {
            throw new SemaforoNaoEncontradoException(identificador);
        }

    }

    public Integer iniciarSemaforo(String identificador) {

        Integer quantidadeSemaforosIniciados = semaforoRepository.updateStatus(Status.ATIVO, identificador);

        if(quantidadeSemaforosIniciados>0){
            return quantidadeSemaforosIniciados;
        } else {
             throw new SemaforoNaoEncontradoException(identificador);
        }
    }


}
