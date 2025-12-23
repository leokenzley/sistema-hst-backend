CREATE SEQUENCE IF NOT EXISTS tb_sprint_seq
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS tb_sprint (
    id BIGINT PRIMARY KEY,
    numero NUMERIC NOT NULL,
    detalhe TEXT null,
    dt_inicio DATE,
    dt_fim DATE,
    status CHAR(1) NOT NULL,
    projeto_id BIGINT NOT NULL,
        CONSTRAINT fk_tb_projeto_sprint
            FOREIGN KEY (projeto_id)
            REFERENCES tb_projeto(id)
);



-- Inserts iniciais para a tabela tb_sprint

INSERT INTO tb_sprint (
    id,
    numero,
    detalhe,
    dt_inicio,
    dt_fim,
    status,
    projeto_id
) VALUES (
    nextval('tb_sprint_seq'),
    1,
    'Primeira sprint do Projeto novo sci',
    NULL,
    NULL,
    'A',
    1
);

INSERT INTO tb_sprint (
    id,
    numero,
    detalhe,
    dt_inicio,
    dt_fim,
    status,
    projeto_id
) VALUES (
    nextval('tb_sprint_seq'),
    2,
    'Primeira sprint do Projeto Qualilab',
    NULL,
    NULL,
    'A',
    2
);
