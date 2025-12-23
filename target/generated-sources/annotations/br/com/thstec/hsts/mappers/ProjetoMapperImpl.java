package br.com.thstec.hsts.mappers;

import br.com.thstec.hsts.entities.ProjetoEntity;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import br.com.thstec.hsts.model.projeto.request.ProjetoRequest;
import br.com.thstec.hsts.model.projeto.response.ProjetoResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-22T23:18:03-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.9 (Microsoft)"
)
@Component
public class ProjetoMapperImpl implements ProjetoMapper {

    @Override
    public ProjetoEntity toEntity(ProjetoRequest request) {
        if ( request == null ) {
            return null;
        }

        ProjetoEntity projetoEntity = new ProjetoEntity();

        projetoEntity.setNome( request.nome() );
        projetoEntity.setDetalhe( request.detalhe() );

        projetoEntity.setStatus( StatusEnum.ATIVO );

        return projetoEntity;
    }

    @Override
    public ProjetoResponse toResponse(ProjetoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        String detalhe = null;
        StatusEnum status = null;

        id = entity.getId();
        nome = entity.getNome();
        detalhe = entity.getDetalhe();
        status = entity.getStatus();

        ProjetoResponse projetoResponse = new ProjetoResponse( id, nome, detalhe, status );

        return projetoResponse;
    }
}
