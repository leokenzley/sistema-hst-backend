package br.com.thstec.hsts.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_tarefa")
public class TarefaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_tarefa_seq")
    @SequenceGenerator(
            name = "tb_tarefa_seq",
            sequenceName = "tb_tarefa_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "desc_hst_ref", columnDefinition = "text")
    private String descricaoHistoricoReferencia;

    @Column(name = "vl_hst_ref", precision = 10, scale = 2)
    private BigDecimal valorHistoricoReferencia;

    @Column(columnDefinition = "text")
    private String detalhe;

    @Column(name = "fator_impacto", columnDefinition = "text")
    private String fatorImpacto;

    @Column(name = "mem_calculo", columnDefinition = "text")
    private String memoriaCalculo;

    @Column(nullable = false, length = 1)
    private String status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "disciplina_id", nullable = false)
    private DisciplinaEntity disciplina;
}

