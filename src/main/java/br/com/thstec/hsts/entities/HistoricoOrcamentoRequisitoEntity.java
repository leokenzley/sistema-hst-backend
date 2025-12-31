package br.com.thstec.hsts.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_hist_orc_req")
public class HistoricoOrcamentoRequisitoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_hist_orc_req_seq")
    @SequenceGenerator(
            name = "tb_hist_orc_req_seq",
            sequenceName = "tb_hist_orc_req_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    @Column(name = "dt_created", nullable = false)
    private LocalDateTime dtCreated;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orc_req_id", nullable = false)
    private OrcamentoRequisitoEntity orcamentoRequisito;
}
