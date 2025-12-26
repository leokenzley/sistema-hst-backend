package br.com.thstec.hsts.services;

import br.com.thstec.hsts.model.orcamento_requisito.request.OrcamentoRequisitoRequest;
import br.com.thstec.hsts.model.orcamento_requisito.response.OrcamentoRequisitoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrcamentoRequisitoService {

    OrcamentoRequisitoResponse created(OrcamentoRequisitoRequest request);

    OrcamentoRequisitoResponse update(Long id, OrcamentoRequisitoRequest request);

    void deleteById(Long id);

    OrcamentoRequisitoResponse findById(Long id);

    Page<OrcamentoRequisitoResponse> getPaginated(Pageable pageable);
}
