-- V202512182207__CREATE_TB_PROJETO.sql
-- Auto-gerado a partir do CSV

CREATE SEQUENCE IF NOT EXISTS tb_projeto_seq
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS tb_projeto (
    id BIGINT PRIMARY KEY,
    nome TEXT NOT NULL,
    detalhe TEXT null,
    status CHAR(1) NOT NULL
);


-- Inserts iniciais para a tabela tb_projeto

INSERT INTO tb_projeto (
    id,
    nome,
    detalhe,
    status
) VALUES (
    nextval('tb_projeto_seq'),
    'Novo SCI',
    'Projeto novo sci',
    'A'
);

INSERT INTO tb_projeto (
    id,
    nome,
    detalhe,
    status
) VALUES (
    nextval('tb_projeto_seq'),
    'Qualilab',
    'Projeto qualilab',
    'A'
);
