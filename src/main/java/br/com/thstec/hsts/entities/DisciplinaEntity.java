package br.com.thstec.hsts.entities;

import br.com.thstec.hsts.model.enumerations.DisciplinaTipoFuncaoEnum;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_disciplina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisciplinaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tb_disciplina")
    @SequenceGenerator(
            name = "seq_tb_disciplina",
            sequenceName = "seq_tb_disciplina",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(nullable = false, length = 1)
    private StatusEnum status;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_funcao", nullable = false)
    private DisciplinaTipoFuncaoEnum tpFuncao;
}
