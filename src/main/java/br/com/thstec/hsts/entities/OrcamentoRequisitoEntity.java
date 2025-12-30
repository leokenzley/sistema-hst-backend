package br.com.thstec.hsts.entities;

import br.com.thstec.hsts.model.enumerations.RequisitoStatusEnum;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_orc_req")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrcamentoRequisitoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_orc_req_seq")
    @SequenceGenerator(
            name = "tb_orc_req_seq",
            sequenceName = "tb_orc_req_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false, columnDefinition = "text")
    private String requisito;

    @Column(columnDefinition = "text")
    private String detalhe;

    @Column(name = "dt_inicio", nullable = false)
    private LocalDate dtInicio;

    @Column(name = "dt_fim")
    private LocalDate dtFim;

    @Column(name = "dt_finalizada")
    private LocalDate dtFinalizada;

    @Column(nullable = false, length = 1)
    private StatusEnum status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sprint_id", nullable = false)
    private SprintEntity sprint;

    /**
     * TODO Adicionar o status do requisito
     * pensando em alguma coisa como quando o requisito não estiver finalizado e outra sprint for criada,
     * levar os requisitos para a nova sprint automaticamente
     */
    /**
    @Enumerated(EnumType.STRING)
    private RequisitoStatusEnum requisitoStatus;
    */
    /**
     *  TODO manter um histórico sobre o requisito como documentação do aconteceu com ele
     private List<HistoricoOrcamentoRequisito> historicos
     */


}

