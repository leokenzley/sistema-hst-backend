package br.com.thstec.hsts.repositories;

import br.com.thstec.hsts.entities.OrcamentoRequisitoFuncionalidadeEntity;
import br.com.thstec.hsts.model.sprint.response.SprintResponseReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrcamentoRequisitoFuncionalidadeRepository
        extends JpaRepository<OrcamentoRequisitoFuncionalidadeEntity, Long> {

    @Query("select orcf from OrcamentoRequisitoFuncionalidadeEntity orcf join fetch orcf.orcamentoRequisito as orc" +
            " where orc.id = :orcId")
    Page<OrcamentoRequisitoFuncionalidadeEntity> getPaginatedByOrcamentoRequisitoId(
            @Param("orcId") Long orcamentoRequisitoId, Pageable pageable);


    @Query("select orcf from OrcamentoRequisitoFuncionalidadeEntity orcf join fetch orcf.orcamentoRequisito as orc " +
            " join fetch orc.sprint as s where s.id = :id")
    List<OrcamentoRequisitoFuncionalidadeEntity> findBySprintId(@Param("id") Long id);
}

