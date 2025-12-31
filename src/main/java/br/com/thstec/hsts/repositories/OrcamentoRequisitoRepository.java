package br.com.thstec.hsts.repositories;

import br.com.thstec.hsts.entities.OrcamentoRequisitoEntity;
import br.com.thstec.hsts.model.enumerations.RequisitoStatusEnum;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrcamentoRequisitoRepository extends JpaRepository<OrcamentoRequisitoEntity, Long> {

    Page<OrcamentoRequisitoEntity> findByStatus(StatusEnum status, Pageable pageable);

    @Query(value = "select tor.* from tb_orc_req tor " +
            "join tb_sprint ts on ts.id = tor.sprint_id " +
            "join tb_projeto tp on tp.id  = ts.projeto_id " +
            "where ts.id = :ultimaSprintId " +
            "and tor.requisito_status IN('CRIADO', 'PENDENTE_VALIDACAO') ", nativeQuery = true)
    List<OrcamentoRequisitoEntity> findAllBySprintIdToMigrate(@Param("ultimaSprintId") Long ultimaSprintId);
}
