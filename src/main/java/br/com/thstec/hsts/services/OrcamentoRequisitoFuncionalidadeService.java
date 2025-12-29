package br.com.thstec.hsts.services;

import br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.request.OrcamentoRequisitoFuncionalidadeRequest;
import br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.response.OrcamentoRequisitoFuncionalidadeResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrcamentoRequisitoFuncionalidadeService {

    OrcamentoRequisitoFuncionalidadeResponse created(OrcamentoRequisitoFuncionalidadeRequest request);

    OrcamentoRequisitoFuncionalidadeResponse update(Long id, OrcamentoRequisitoFuncionalidadeRequest request);

    void deleteById(Long id);

    OrcamentoRequisitoFuncionalidadeResponse findById(Long id);

    Page<OrcamentoRequisitoFuncionalidadeResponse> getPaginated(Pageable pageable);
}

