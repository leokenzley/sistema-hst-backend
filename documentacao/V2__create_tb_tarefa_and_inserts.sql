
-- V2__create_tb_tarefa_and_inserts.sql

CREATE SEQUENCE IF NOT EXISTS tb_tarefa_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE IF NOT EXISTS tb_tarefa (
    id              BIGINT PRIMARY KEY DEFAULT nextval('tb_tarefa_seq'),
    nome            TEXT NOT NULL,
    desc_hst_ref    TEXT NOT NULL,
    vl_hst_ref      DOUBLE PRECISION NOT NULL,
    detalhe         TEXT,
    fator_impacto   TEXT,
    mem_calculo     TEXT,
    status          CHAR(1) NOT NULL CHECK (status IN ('A', 'I')),
    disciplina_id   BIGINT NOT NULL,
    CONSTRAINT fk_tb_tarefa_disciplina
        FOREIGN KEY (disciplina_id)
        REFERENCES tb_disciplina (id)
);

-- INSERTS

INSERT INTO tb_tarefa
(nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id)
VALUES (
'Refinamento e Documentação de requisitos, de forma a permitir sua implementação.',
'0,5 por tarefa refinada',
0.5,
'Os requisitos devem ser documentados em formato de histórias, de acordo com os critérios do Guia de Projetos de Software com Métodos Ágeis do SISP. Outra referência é o livro “Scrum Product Ownership” do Robert Galen. A história será dividida em tarefas e as tarefas devem ser refinadas  este momento. Deve-se documentar o que deve ser feito em cada tarefa.',
NULL,
NULL,
'A',
1
);

INSERT INTO tb_tarefa
(nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id)
VALUES (
'Reunião de Refinamento com desenvolvedor(es)',
'1 por hora de reunião, por profissional desenvolvedor',
1,
'Quando for necessário ouvir previamente a opinião técnica de desenvolvedores, para se definir a melhor estratégia de solução para determinado problema.',
NULL,
NULL,
'A',
1
);

INSERT INTO tb_tarefa
(nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id)
VALUES (
'Elaboração de template novo para um sistema novo',
'8',
8,
'Conjunto de artefatos que servem de estrutura inicial para o frontend de um novo sistema.',
NULL,
NULL,
'A',
2
);
