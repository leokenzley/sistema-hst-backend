package br.com.thstec.hsts.repositories;

import br.com.thstec.hsts.entities.SprintEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SprintRepository extends JpaRepository<SprintEntity, Long> {

    @Query("select s from SprintEntity s join s.projeto p where p.id = :projectId")
    Page<SprintEntity> findAllByProjetoIdPaganated(@Param("projectId") Long projectId, Pageable pageable);

    @Query("select s from SprintEntity s join s.projeto p where p.id = :projectId")
    List<SprintEntity> findAllByProjetoIdList(@Param("projectId") Long projectId);
}
