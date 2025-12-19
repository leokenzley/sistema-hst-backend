-- =========================================================
-- 202512181929__CREATE_TB_DISCIPLINA.sql
-- Criação da tabela tb_disciplina + sequence + dados iniciais
-- Banco: PostgreSQL
-- =========================================================

-- =========================
-- 1. Criação da SEQUENCE
-- =========================
CREATE SEQUENCE seq_tb_disciplina
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- =========================
-- 2. Criação da TABELA
-- =========================
CREATE TABLE tb_disciplina (
    id         BIGINT NOT NULL DEFAULT nextval('seq_tb_disciplina'),
    descricao  VARCHAR(255) NOT NULL,
    status     CHAR(1)      NOT NULL,
    tp_funcao  VARCHAR(255) NOT NULL,

    CONSTRAINT pk_tb_disciplina PRIMARY KEY (id),
    CONSTRAINT ck_tb_disciplina_status
        CHECK (status IN ('A', 'I'))
);

-- =========================
-- 3. Associação da SEQUENCE à coluna (boa prática)
-- =========================
ALTER SEQUENCE seq_tb_disciplina
OWNED BY tb_disciplina.id;

-- =========================
-- 4. Inserts iniciais
-- =========================

-- TP_FUNCAO = NOVA_FUNCIONALIDADE
INSERT INTO tb_disciplina (id, descricao, status, tp_funcao) VALUES
(nextval('seq_tb_disciplina'), 'Requisitos', 'A', 'NOVA_FUNCIONALIDADE'),
(nextval('seq_tb_disciplina'), 'Design', 'A', 'NOVA_FUNCIONALIDADE'),
(nextval('seq_tb_disciplina'), 'Análise', 'A', 'NOVA_FUNCIONALIDADE'),
(nextval('seq_tb_disciplina'), 'Análise/Design', 'A', 'NOVA_FUNCIONALIDADE'),
(nextval('seq_tb_disciplina'), 'Codificação', 'A', 'NOVA_FUNCIONALIDADE'),
(nextval('seq_tb_disciplina'), 'Codificação / Banco de Dados', 'A', 'NOVA_FUNCIONALIDADE'),
(nextval('seq_tb_disciplina'), 'Codificação / PDF', 'A', 'NOVA_FUNCIONALIDADE'),
(nextval('seq_tb_disciplina'), 'Configuração de Ambiente', 'A', 'NOVA_FUNCIONALIDADE'),
(nextval('seq_tb_disciplina'), 'Integração de Sistemas', 'A', 'NOVA_FUNCIONALIDADE'),
(nextval('seq_tb_disciplina'), 'Banco de Dados', 'A', 'NOVA_FUNCIONALIDADE'),
(nextval('seq_tb_disciplina'), 'Testes', 'A', 'NOVA_FUNCIONALIDADE'),
(nextval('seq_tb_disciplina'), 'Treinamento / Consultoria', 'A', 'NOVA_FUNCIONALIDADE'),
(nextval('seq_tb_disciplina'), 'Planejamento', 'A', 'NOVA_FUNCIONALIDADE'),
(nextval('seq_tb_disciplina'), 'Documentação', 'A', 'NOVA_FUNCIONALIDADE'),
(nextval('seq_tb_disciplina'), 'Outros', 'A', 'NOVA_FUNCIONALIDADE'),
(nextval('seq_tb_disciplina'), 'Alteração de Código', 'A', 'NOVA_FUNCIONALIDADE'),
(nextval('seq_tb_disciplina'), 'Análise e correção de bugs', 'A', 'NOVA_FUNCIONALIDADE'),
(nextval('seq_tb_disciplina'), 'Estudo de Código', 'A', 'NOVA_FUNCIONALIDADE');

-- TP_FUNCAO = MANUTENCAO
INSERT INTO tb_disciplina (id, descricao, status, tp_funcao) VALUES
(nextval('seq_tb_disciplina'), 'Alteração de Código', 'A', 'MANUTENCAO'),
(nextval('seq_tb_disciplina'), 'Análise e correção de bugs', 'A', 'MANUTENCAO'),
(nextval('seq_tb_disciplina'), 'Estudo de Código', 'A', 'MANUTENCAO');
