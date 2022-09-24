package br.anhembi.tcc.trafficmanagement.repository;

import br.anhembi.tcc.trafficmanagement.model.SemaforoModel;
import br.anhembi.tcc.trafficmanagement.model.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface SemaforoRepository extends JpaRepository<SemaforoModel, Long> {

    Integer deleteByIdentificador(String identificador);

    Optional<SemaforoModel> findByIdentificador(String identificador);

    Page<SemaforoModel> findAll(Pageable pageable);

    @Modifying
    @Query("update SemaforoModel u set u.status = :status where u.identificador = :identificador")
    Integer updateStatus(@Param("status") Status status, @Param("identificador") String identificador);

}
