CREATE SEQUENCE IF NOT EXISTS tb_orc_req_func_seq
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS tb_orc_req_func (
    id BIGINT PRIMARY KEY,
    orc_req_id BIGINT NOT NULL,
    tarefa_id BIGINT NOT NULL,
    observacao TEXT null,
    comprovante TEXT null,
    qt_hst NUMERIC (10,2) NOT NULL,
    vl_fi NUMERIC (10,2) NOT NULL,
    CONSTRAINT fk_tb_orc_req_orc_rec_func
        FOREIGN KEY (orc_req_id)
        REFERENCES tb_orc_req(id),

    CONSTRAINT fk_tb_tarefa_orc_rec_func
        FOREIGN KEY (tarefa_id)
        REFERENCES tb_tarefa(id)
);
