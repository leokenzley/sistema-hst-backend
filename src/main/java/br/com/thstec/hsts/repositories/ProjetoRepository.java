package br.com.thstec.hsts.repositories;

import br.com.thstec.hsts.entities.ProjetoEntity;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<ProjetoEntity, Long> {
    @Query("select p from ProjetoEntity p where (:status is null or p.status = :status)")
    Page<ProjetoEntity> findByStatusOrderByNomeAsc(@Param("status") StatusEnum status, Pageable pageable);
}
