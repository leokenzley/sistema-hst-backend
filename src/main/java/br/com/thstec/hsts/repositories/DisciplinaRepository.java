package br.com.thstec.hsts.repositories;

import br.com.thstec.hsts.entities.DisciplinaEntity;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, Long> {

    @Query("select d from DisciplinaEntity d where (:status is null or d.status = :status)")
    Page<DisciplinaEntity> findByStatus(@Param("status") StatusEnum status, Pageable pageable);
}
