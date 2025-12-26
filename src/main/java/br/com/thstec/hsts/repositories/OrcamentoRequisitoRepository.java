package br.com.thstec.hsts.repositories;

import br.com.thstec.hsts.entities.OrcamentoRequisitoEntity;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoRequisitoRepository extends JpaRepository<OrcamentoRequisitoEntity, Long> {

    Page<OrcamentoRequisitoEntity> findByStatus(StatusEnum status, Pageable pageable);
}
