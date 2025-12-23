package br.com.thstec.hsts.entities;

import br.com.thstec.hsts.model.enumerations.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_projeto")
@Getter
@Setter
@NoArgsConstructor
public class ProjetoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_projeto_seq")
    @SequenceGenerator(
            name = "tb_projeto_seq",
            sequenceName = "tb_projeto_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "detalhe")
    private String detalhe;

    @Column(nullable = false, length = 1)
    private StatusEnum status;
}
