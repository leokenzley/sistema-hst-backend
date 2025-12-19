

/**
tabela tb_disciplina, colunas:
- ID númerico, chave primária 
- DESC varchar 255, not null 
- STATUS A de ativo ou I de inativo.
- TP_FUNCAO varchar 255, not null.

Os valores iniciais abaixo da tabela, STATUS A, TP_FUNCAO NOVA_FUNCIONALIDADE

Requisitos,
Design,
Análise,
Análise/Design,
Codificação,
Codificação / Banco de Dados,
Codificação / PDF,
Configuração de Ambiente,
Integração de Sistemas,
Banco de Dados,
Testes,
Treinamento / Consultoria,
Planejamento,
Documentação,
Outros,
Alteração de Código,
Análise e correção de bugs,
Estudo de Código,

Os valores iniciais abaixo da tabela, STATUS A, TP_FUNCAO MANUTENCAO

Alteração de Código
Análise e correção de bugs
Estudo de Código
*/

CREATE SEQUENCE seq_tb_disciplina
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE tb_disciplina (
    id         BIGINT NOT NULL DEFAULT nextval('seq_tb_disciplina'),
    descricao  VARCHAR(255) NOT NULL,
    status     CHAR(1)      NOT NULL,
    tp_funcao  VARCHAR(255) NOT NULL,

    CONSTRAINT pk_tb_disciplina PRIMARY KEY (id),
    CONSTRAINT ck_tb_disciplina_status
        CHECK (status IN ('A', 'I'))
);


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


INSERT INTO tb_disciplina (id, descricao, status, tp_funcao) VALUES
(nextval('seq_tb_disciplina'), 'Alteração de Código', 'A', 'MANUTENCAO'),
(nextval('seq_tb_disciplina'), 'Análise e correção de bugs', 'A', 'MANUTENCAO'),
(nextval('seq_tb_disciplina'), 'Estudo de Código', 'A', 'MANUTENCAO');


/**
Tarefa:
Criar uma sequence para esta tabela.
Colunas da tabela tb_tarefa:
- ID númerico, chave primária 
- NOME text, not null
- DESC_HST_REF text not null
- VL_HST_REF float not null
- DETALHE text, null
- FATOR_IMPACTO text, null
- MEM_CALCULO text, null
- STATUS A de ativo ou I de inativo.
- DISCIPLINA_ID é a chave primária da tabela tb_disciplina



*/

