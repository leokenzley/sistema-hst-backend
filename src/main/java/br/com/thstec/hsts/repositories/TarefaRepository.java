package br.com.thstec.hsts.repositories;

import br.com.thstec.hsts.entities.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaEntity, Long> {
}
