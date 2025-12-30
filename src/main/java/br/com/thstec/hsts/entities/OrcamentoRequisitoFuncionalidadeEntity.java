package br.com.thstec.hsts.entities;

import br.com.thstec.hsts.model.enumerations.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_orc_req_func")
public class OrcamentoRequisitoFuncionalidadeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_orc_req_func_seq")
    @SequenceGenerator(
            name = "tb_orc_req_func_seq",
            sequenceName = "tb_orc_req_func_seq",
            allocationSize = 1
    )
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orc_req_id", nullable = false)
    private OrcamentoRequisitoEntity orcamentoRequisito;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tarefa_id", nullable = false)
    private TarefaEntity tarefa;

    @Column(columnDefinition = "text")
    private String observacao;

    @Column(columnDefinition = "text")
    private String comprovante;

    @Column(name = "qt_hst", nullable = false, precision = 10, scale = 2)
    private BigDecimal quantidadeHoras;

    @Column(name = "vl_fi", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorFinal;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, length = 1)
    private StatusEnum status;
}

