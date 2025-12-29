package br.com.thstec.hsts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoRequisitoFuncionalidadeRepository
        extends JpaRepository<br.com.thstec.hsts.entities.OrcamentoRequisitoFuncionalidadeEntity, Long> {
}

