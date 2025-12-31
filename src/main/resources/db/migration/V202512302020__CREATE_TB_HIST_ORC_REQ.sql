CREATE SEQUENCE IF NOT EXISTS tb_hist_orc_req_seq
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS tb_hist_orc_req (
    id BIGINT PRIMARY KEY,
    observacao TEXT null,
    dt_created DATE not null,
    orc_req_id BIGINT NOT NULL,
    CONSTRAINT fk_tb_hist_orc_req_orc_req
        FOREIGN KEY (orc_req_id)
        REFERENCES tb_orc_req(id)
);