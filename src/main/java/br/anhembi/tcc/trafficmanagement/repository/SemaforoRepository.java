package br.anhembi.tcc.trafficmanagement.repository;

import br.anhembi.tcc.trafficmanagement.model.SemaforoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SemaforoRepository extends JpaRepository<SemaforoModel, Long> {

    Optional<Long> deleteByIdentificador(String identificador);

    Optional<SemaforoModel> findByIdentificador(String identificador);

    Page<SemaforoModel> findAll(Pageable pageable);

}
