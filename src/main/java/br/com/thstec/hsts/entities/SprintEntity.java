package br.com.thstec.hsts.entities;


import br.com.thstec.hsts.model.enumerations.StatusEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_sprint")
public class SprintEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_sprint_seq")
    @SequenceGenerator(
            name = "tb_sprint_seq",
            sequenceName = "tb_sprint_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false)
    private Integer numero;

    @Column(columnDefinition = "text")
    private String detalhe;

    @Column(name = "dt_inicio")
    private LocalDate dtInicio;

    @Column(name = "dt_fim")
    private LocalDate dtFim;

    @Column(nullable = false, length = 1)
    private StatusEnum status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "projeto_id", nullable = false)
    private ProjetoEntity projeto;

}
