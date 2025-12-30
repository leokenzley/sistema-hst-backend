package br.com.thstec.hsts.repositories;

import br.com.thstec.hsts.entities.TarefaEntity;
import br.com.thstec.hsts.model.enumerations.DisciplinaTipoFuncaoEnum;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaEntity, Long> {

    @Query("select t from TarefaEntity t " +
            " join fetch t.disciplina d " +
            "where " +
            " (:status is null or t.status = :status) " +
            " and (:tpFuncao is null or d.tpFuncao = :tpFuncao)")
    List<TarefaEntity> getListByStatus(
            @Param("status") StatusEnum status,
            @Param("tpFuncao") DisciplinaTipoFuncaoEnum tpFuncao
            );

    @Query("select t from TarefaEntity t " +
            " join fetch t.disciplina d " +
            "where " +
            " (:status is null or t.status = :status) " +
            " and (:tpFuncao is null or d.tpFuncao = :tpFuncao)")
    Page<TarefaEntity> getPaginated(
            Pageable pageable,
            @Param("status") StatusEnum status,
            @Param("tpFuncao") DisciplinaTipoFuncaoEnum tpFuncao);
}
