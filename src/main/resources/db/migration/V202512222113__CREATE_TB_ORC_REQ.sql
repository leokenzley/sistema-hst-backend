CREATE SEQUENCE IF NOT EXISTS tb_orc_req_seq
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS tb_orc_req (
    id BIGINT PRIMARY KEY,
    sprint_id BIGINT NOT NULL,
    requisito TEXT NOT NULL,
    detalhe TEXT null,
    dt_inicio DATE not null,
    dt_fim DATE null,
    dt_finalizada DATE,
    CONSTRAINT fk_tb_sprint_orc_req
        FOREIGN KEY (sprint_id)
        REFERENCES tb_sprint(id)
);