package br.com.thstec.hsts.repositories;

import br.com.thstec.hsts.entities.DisciplinaEntity;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, Long> {

    Page<DisciplinaEntity> findByStatus(StatusEnum status, Pageable pageable);
}
