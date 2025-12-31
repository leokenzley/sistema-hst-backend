package br.com.thstec.hsts.repositories;


import br.com.thstec.hsts.entities.HistoricoOrcamentoRequisitoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoOrcamentoRequisitoRepository
        extends JpaRepository<HistoricoOrcamentoRequisitoEntity, Long> {

     @Query("select h from HistoricoOrcamentoRequisitoEntity h join fetch h.orcamentoRequisito o" +
             " where o.id = :orcamentoRequisitoId")
     Page<HistoricoOrcamentoRequisitoEntity> getPaginated(Long orcamentoRequisitoId, Pageable pageable);
}
