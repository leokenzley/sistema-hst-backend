package br.com.thstec.hsts.services;

import br.com.thstec.hsts.model.projeto.request.ProjetoRequest;
import br.com.thstec.hsts.model.projeto.response.ProjetoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjetoService {

    ProjetoResponse created(ProjetoRequest request);

    ProjetoResponse update(Long id, ProjetoRequest request);

    void deleteById(Long id);

    ProjetoResponse findById(Long id);

    Page<ProjetoResponse> getPaginated(Pageable pageable);
}
