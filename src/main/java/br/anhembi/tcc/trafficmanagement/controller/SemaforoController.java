package br.anhembi.tcc.trafficmanagement.controller;

import br.anhembi.tcc.trafficmanagement.dto.SemaforoImputDTO;
import br.anhembi.tcc.trafficmanagement.dto.SemaforoOutputDTO;
import br.anhembi.tcc.trafficmanagement.model.Status;
import br.anhembi.tcc.trafficmanagement.service.SemaforoService;
import br.anhembi.tcc.trafficmanagement.service.impl.SemaforoServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SemaforoController {

    private final SemaforoService semaforoService;

    public SemaforoController(SemaforoServiceImpl semaforoService) {
        this.semaforoService = semaforoService;
    }

    @GetMapping("/semaforo")
    public ResponseEntity<Page<SemaforoOutputDTO>> buscarSemaforos(
            @RequestParam(defaultValue = "") Status status,
            @PageableDefault(value = 10, page = 0) Pageable pageable) {

        return ResponseEntity.ok(semaforoService.buscarSemaforos(pageable));

    }

    @GetMapping("/semaforo/{identificador}")
    public ResponseEntity<SemaforoOutputDTO> buscarSemaforo(@PathVariable String identificador) {

        return ResponseEntity.ok(semaforoService.buscarSemaforo(identificador));

    }

    @PostMapping("/semaforo")
    public ResponseEntity<SemaforoOutputDTO> criarSemaforo(@RequestBody SemaforoImputDTO semaforoImputDTO, HttpServletRequest request) {
        SemaforoOutputDTO semaforo = semaforoService.criar(semaforoImputDTO, request.getRemoteAddr(), request.getRemotePort());
        return new ResponseEntity<>(semaforo, HttpStatus.CREATED);
    }

    @PutMapping("/semaforo/{identificador}")
    ResponseEntity<SemaforoOutputDTO> iniciarSemaforo(@PathVariable String identificador) {
        semaforoService.iniciarSemaforo(identificador);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/semaforo/{identificador}")
    public ResponseEntity<Long> deletarSemaforo(@PathVariable String identificador) {
        semaforoService.deletar(identificador);
        return ResponseEntity.accepted().build();
    }

}
