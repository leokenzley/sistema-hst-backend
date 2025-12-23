-- V202512182149__CREATE_TB_TAREFA.sql
-- Auto-gerado a partir do CSV

CREATE SEQUENCE IF NOT EXISTS tb_tarefa_seq
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS tb_tarefa (
    id BIGINT PRIMARY KEY,
    nome TEXT NOT NULL,
    desc_hst_ref TEXT NULL,
    vl_hst_ref NUMERIC(10,2) NULL,
    detalhe TEXT null,
    fator_impacto TEXT null,
    mem_calculo TEXT null,
    status CHAR(1) NOT NULL,
    disciplina_id BIGINT NOT NULL,
    CONSTRAINT fk_tb_tarefa_disciplina
        FOREIGN KEY (disciplina_id)
        REFERENCES tb_disciplina(id)
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Refinamento e Documentação de requisitos, de forma a permitir sua implementação.',
    '0,5 por tarefa refinada',
    0.5,
    'Os requisitos devem ser documentados em formato de histórias, de acordo com os critérios do Guia de Projetos de Software com Métodos Ágeis do SISP. Outra referência é o livro “Scrum Product Ownership” do Robert Galen. A história será dividida em tarefas e as tarefas devem ser refinadas  este momento. Deve-se documentar o que deve ser feito em cada tarefa.',
    NULL,
    NULL,
    'A',
    1
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Reunião de Refinamento com desenvolvedor(es)',
    '1 por hora de reunião, por profissional desenvolvedor',
    1,
    'Quando for necessário ouvir previamente a opinião técnica de desenvolvedores, para se definir a melhor estratégia de solução para determinado problema. Estima-se que um refinamento leve 1 hora, com participação de 2 técnicos da CONTRATADA (pelo menos). Deve documentar as decisões  sobre direcionamentos ou estratégias a serem adotadas.',
    NULL,
    NULL,
    'A',
    1
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Elaboração de template novo para um sistema novo',
    '8',
    8,
    'Conjunto de artefatos que servem de estrutura inicial para o frontend de um novo sistema. Ex. arquivos html, css, ícones. Conjunto de artefatos que servem de exemplo para construção de um sistema. Envolve os vários tipos de tela, componentes etc. Apenas a parte de design em html, css, ícones. Não é a programação em si.',
    NULL,
    NULL,
    'A',
    2
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Adaptação de template existente para um sistema novo',
    '4',
    4,
    'Alterações na estrutura dos artefatos do template existente
para atender demanda do novo sistema. Ex. alteração de
cores, alteração de posição de menus de navegação.',
    NULL,
    NULL,
    'A',
    2
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Elaboração de tela (html/css) baseada em template existente',
    '1',
    1,
    'Tela funcional que poderá ser utilizada na programação.',
    NULL,
    NULL,
    'A',
    2
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Elaboração de tela (html/css) baseada em template, mas que contenha itens que exijam diagramação única (como um mapa, ou imagem específica)',
    '2',
    2,
    'Adaptação de uma tela do template para se ajHSTar a um novo elemento. Ex. para uma tela específica um mapa ou imagem deverá ocupar um espaço maior na tela.',
    NULL,
    NULL,
    'A',
    2
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Alteração pontual em tela (html/css) existente',
    '0,5',
    0.5,
    NULL,
    NULL,
    NULL,
    'A',
    2
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Elaboração e documentação do Desenho/Arquitetura da solução, para projetos novos',
    '6',
    6,
    NULL,
    NULL,
    NULL,
    'A',
    3
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Criação de protótipo de uma tela baseado em template existente',
    '1',
    1,
    'Protótipo, desenho.',
    NULL,
    NULL,
    'A',
    4
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Modelagem de banco de dados',
    '0,5 por classe de objeto',
    0.5,
    'Elaboração do DER (Diagrama Entidade-Relacionamento)',
    NULL,
    NULL,
    'A',
    3
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Elaboração de backlog do produto',
    '0,5 a cada duas histórias',
    0.5,
    'Trata-se da preparação dos itens do backlog feito pela CONTRATADA, tirando dúvidas e esclarecendo as históricas com o P.O. técnico e o P.O. de negócios. Deve ficar claro o que é necessário para o item do backlog. Depois, na Sprint, a história é quebrada em tarefas e para cada tarefa é feito a especificação técnica.',
    NULL,
    NULL,
    'A',
    3
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Página de listagem padrão (frontend/backend), incluindo ordenação dos campos na tabela',
    '5',
    5,
    'Deve permitir a seleção e exclusão de objetos da lista.',
    NULL,
    NULL,
    'A',
    5
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Página de detalhe padrão de entidade (html/java), com opções de criação, visualização e alteração dos dados.',
    '1-25 campos: 7
> 25: 9',
    7,
    'Campos com algum comportamento (ex.: autocomplete) serão remunerados a parte.',
    NULL,
    NULL,
    'A',
    5
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Elaboração de tela (html/css/js/java), quando não há template, ou que exija diagramação única',
    '9',
    9,
    'Tela com design diferenciado do padrão, que não sejam listagem nem detalhe de entidade. Ex. dashboard. Campos com algum comportamento (ex.: autocomplete) serão remunerados a parte.',
    NULL,
    NULL,
    'A',
    5
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Elaboração de componente de tela (html/css/js/java), quando não há template, ou que exija diagramação única',
    '4',
    4,
    'Similar ao item anterior, mas para situações em que apenas parte da tela (um componente) será cHSTomizado.',
    NULL,
    NULL,
    'A',
    5
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Programação de 1 operação de banco (criação, leitura, atualização, remoção) no back-end, com dados submetidos pelo front-end. (Programação completa, incluindo validação do campo, sanitização das “strings” etc.)',
    '4',
    4,
    'Ex. Para uma tela de cadastro de cliente a programação completa do CRUD no backend para os dados do cliente.',
    NULL,
    NULL,
    'A',
    5
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Programação de 1 funcionalidade simples de usabilidade, no front-end (exemplos: uma caixa de diálogo; em Javascript)',
    '2 para o primeiro (se não houver componente pronto);
0,5 para os demais repetidos no mesmo sistema',
    2,
    NULL,
    NULL,
    NULL,
    'A',
    5
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Filtros na página de listagem',
    '1',
    1,
    'Filtrar usando atributos das entidades listadas.',
    NULL,
    NULL,
    'A',
    5
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Programação de validação de campos de formulário, baseado em regras de negócio simples',
    '0,5 por campo',
    0.5,
    'Não inclui validações padrão de formulários (ex.: tamanho e formato de campo, máscara, obrigatoriedade de preenchimento)',
    NULL,
    NULL,
    'A',
    5
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Componentes diferentes de caixa de texto livre (ex.: combo box, autocomplete) (html/java), incluindo a sua documentação',
    'A cada cinco componentes: 0,5',
    0.5,
    'Pela maior complexidade, esse tipo de objeto não está incluído na página de listagem ou de detalhe, devendo ser pago à parte.
Componentes corporativos já existentes e reutilizáveis serão considerados como caixa de texto livre.',
    NULL,
    NULL,
    'A',
    5
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Comportamento de elementos da tela (tabela, grid, combo) que dependa de outros inputs',
    '0,5 por comportamento',
    0.5,
    'Idem ao anterior.',
    NULL,
    NULL,
    'A',
    5
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Implementação de operação de regra de negócio complexa, a partir de determinado evento.',
    '2 por operação

Caso envolva integração com outro sistema: +1',
    2,
    'Operação que executa uma regra de negócio complexa. Ex.: ao clicar num botão.
Pode ser usada também para criação de tarefas assíncronas (tasks).
Não pode ser usada para remunerar funcionalidades ‘CRUD’.',
    NULL,
    NULL,
    'A',
    5
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Incluir input para upload de arquivo e fazer o tratamento do arquivo no servidor (banco, fileSystem, repositório)',
    '1',
    1,
    'Incluir campo na tela e na tabela do banco de dados.',
    NULL,
    NULL,
    'A',
    5
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Implementar Painel de cadastro (html/java), dentro de uma página de detalhe, que apresenta o objeto pai e seus objetos filhos, com possibilidade de adicionar, remover ou alterar. (Ex.: MasterDetail)',
    '4 por Painel ou tela',
    4,
    NULL,
    NULL,
    NULL,
    'A',
    5
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Atribuição de ações de autorização (permissões) em partes específicas de telas (botões, divs, etc.).',
    'A cada dois: 0,5',
    0.5,
    'Utilizar os serviços providos pelo Sistema de Gestão de Identidades da Agência ou permissões considerando algum cadastro do próprio sistema (ex.: usuário está cadastrado como administrador do sistema)',
    NULL,
    NULL,
    'A',
    5
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Alteração de labels / tooltips em telas existentes',
    'A cada cinco alterações: 0,5',
    0.5,
    'Inclui alteração dos nomes no Java e no Banco de Dados.',
    NULL,
    NULL,
    'A',
    5
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Criar uma nova entidade (Java/SQL), incluindo sequence, relacionamentos e garantindo o versionamento nos ambientes de homologação/produção.',
    'Estrutura inicial: 0,5; A cada cinco atributos: + 0,5; A cada dois relacionamentos mapeados: +0,5',
    0.5,
    'Inclui relacionamentos de cardinalidade, cascades e fetchs. Entidades meramente associativas, criadas apenas para normalização do banco ou que não são ‘visíveis’ para o negócio NÃO serão remuneradas por essa atividade.
Envolve a criação da entidade Java, mapeamento dos relacionamentos no Java, criação dos scripts de banco para gerar tabela, sequence, etc., e versionamento do banco.',
    NULL,
    NULL,
    'A',
    6
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Criar nova procedure ou function ou package do banco de dados',
    '3 e em caso de package 2 por cada método dentro do pacote',
    3,
    'Criar o código DDL no banco de dados e gerar script para versionamento e rodar nas bases de homologação e produção.',
    NULL,
    NULL,
    'A',
    6
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Busca complexa, ainda não implementada, que envolve mais de uma entidade ou coleções de atributos, atributos filhos, JOINs, etc.',
    '2',
    2,
    'Buscas simples estão embutidas nas outras atividades, e não serão pagas num item específico. Buscas simples são as que utilizam Criteria, Spring Data, atributos da própria entidade. Esta necessidade deve ser explicitamente levantada na Planning.',
    NULL,
    NULL,
    'A',
    6
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Busca textual “Oracle
text” ou equivalente
(para outros DBs)',
    '8',
    8,
    'Recurso do Oracle para usar campos de texto longo nas cláusulas where.',
    NULL,
    NULL,
    'A',
    6
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Diagramar e implementar arquivo PDF a ser gerado pelo sistema (relatório simples)',
    '5',
    5,
    'Modelo baseado em relatórios já implementados no sistema ou baseado em modelos preexistentes da ferramenta (ex.: iReports).',
    NULL,
    NULL,
    'A',
    7
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Diagramar e implementar arquivo PDF a ser gerado pelo sistema (relatório complexo)',
    '15',
    15,
    'Mais que 25 campos de dados, ou quando não há um modelo similar para ser reutilizado. (Ex.: Minuta de contrato nova)',
    NULL,
    NULL,
    'A',
    7
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Configuração inicial do ambiente para início de um projeto',
    'Novo sistema: 12
Evolução de sistema existente: 7',
    12,
    'Configurar Liquibase, arquétipo, envers, jasper, git, etc. Não será pago por desenvolvedor, e sim por equipe (célula Scrum) na primeira Solicitação de serviço relativa ao sistema.',
    NULL,
    NULL,
    'A',
    8
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Disponibilizar funcionalidade do sistema para acesso externo, via WebService, Swagger ou similar',
    '1 por operação',
    1,
    'Exemplo de operação: método de um webservice rest.
Incluir a documentação da operação (parâmetros, retorno, etc.).',
    NULL,
    NULL,
    'A',
    9
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Integração do produto com o repositório de arquivos (configurar a primeira vez)',
    '6',
    6,
    'Integração de um sistema (produto) interno ou externo com um servidor para armazenar arquivos quando não quiser armazenar os arquivos no banco. A programação das operações de ler e escrever no disco. Pode ser também um sistema para armazenar arquivos.',
    NULL,
    NULL,
    'A',
    9
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Configuração inicial da integração com outro sistema via Web Services, API Swagger ou similar',
    '2',
    2,
    'A configuração da aplicação que vai consumir o serviço externo, caso necessário. Um sistema pode não ter as libs para acessar um webservice por exemplo, esse tempo seria para o programador preparar a aplicação.',
    NULL,
    NULL,
    'A',
    9
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Disponibilizar uma funcionalidade na Central de Serviços (Service Discovery)',
    '2',
    2,
    'Apenas a lógica para apresentar na central, considerando que a funcionalidade já está implementada no sistema. Inclui configuração de autorização.',
    NULL,
    NULL,
    'A',
    9
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Criação de script para operação direta em banco de dados para inserção em lote de dados, ou devido a alteração da estrutura das tabelas.',
    '2',
    2,
    NULL,
    NULL,
    NULL,
    'A',
    10
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Criação de VIEW, utilizando dados de tabelas distintas e operações DML e funções do Banco de Dados',
    '1,5',
    1.5,
    NULL,
    NULL,
    NULL,
    'A',
    10
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Implementar Cenário de Testes (BDD) automatizados',
    '5 por cenário*',
    5,
    'Utilizando as práticas do Behaviour Driven Development – BDD, automatizar um cenário de negócio, testando inclusive a integração dos componentes da camada de serviço para baixo. Se necessário, criar mocks.
Testes unitários ‘padrão’ não serão remunerados por essa atividade.

*Cenário é a descrição das ações e condições da execução do sistema para alcançar um objetivo',
    NULL,
    NULL,
    'A',
    11
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Horas de Treinamento / Consultoria / Tarefas não previstas',
    '1 por hora de
trabalho (préaprovado
pela CASAN)',
    1,
    'Tarefas não possíveis de serem previstas, ou de complexidade não estimável a priori. Deverá ser usado esporadicamente, com a devida justificativa. Poderá ser usada também para apoio ao P.O. nos treinamentos realizados para usuários e/ou gestores de negócio.',
    NULL,
    NULL,
    'A',
    12
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Estimar a quantidade de HSTs baseado no Repertório de Estimativas',
    '1 por semana de duração da Sprint',
    1,
    'Como as histórias já foram detalhadas e analisadas na planning, o trabalho aqui é procurar na tabela e compor a pontuação final de cada história ou atividade. O resultado sempre será validado pelos fiscais do contrato.',
    NULL,
    NULL,
    'A',
    13
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Reunião de Planejamento de Sprint (Planning)',
    '1 por hora de reunião, por analista desenvolvedor',
    1,
    'Para fins de remuneração da CONTRATADA, a duração máxima da reunião será de 1,5 horas para cada semana de Sprint.
Exemplo: a planning de uma Sprint de 4 semanas será remunerada considerando, no máximo, 6 horas de reunião.
Serão considerados participantes apenas integrantes da célula Scrum já alocados no projeto (Profissionais desenvolvedores).',
    NULL,
    NULL,
    'A',
    13
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Research  Spike:  pesquisa, investigação, explicação ou prototipação  para  melhor entendimento de aspectos técnicos e/ou funcionais.',
    'Entre 2 e 8 (pré-aprovado)',
    8,
    'Propósito:  analisar  alguma  grande funcionalidade e subdividi-la, detectar   riscos   e   complexidades, e/ou explorar estratégias de arquitetura   e design. Devegerar uma documentação com as conclusões da pesquisa.',
    NULL,
    NULL,
    'A',
    13
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Elaborar Documento de Retrospectiva de Sprint',
    '1 por hora de reunião, por analista desenvolvedor',
    1,
    'Duração máxima (para fins de remuneração): 1 hora por analista desenvolvedor.',
    NULL,
    NULL,
    'A',
    13
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Reunião de Demonstração da Sprint (Review)',
    '1 por hora de reunião, por analista desenvolvedor',
    1,
    'Duração máxima (para fins de remuneração): 1 hora para cada semana de Sprint. Os demais requisitos são iguais ao da “Reunião de Planejamento da Sprint”.',
    NULL,
    NULL,
    'A',
    13
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Preparar Demonstração da Sprint: elaborar roteiro de apresentação das funcionalidades, roteiro de testes e preparação dos dados para testes.',
    'Simples: 1% da quantidade de HSTs da Sprint
Complexo: 2% da quantidade de HSTs da Sprint',
    NULL,
    'O padrão é ‘Simples’. Será considerado ‘Complexo’ apenas quando houver necessidade de cadastro de várias Entidades, e/ou combinação de cenários específicos para os dados.',
    NULL,
    NULL,
    'A',
    13
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Elaboração de Manual do Usuário',
    '1 por três histórias',
    1,
    'Pode ser um manual para usar uma tela de cadastro, ou para usar um determinado componente.',
    NULL,
    NULL,
    'A',
    14
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Execução de atividades especificadas em Ordem de Serviço específica e com planejamento previamente aprovado pela Agência (exemplo: UX)',
    '1 HST por hora prevista no planejamento',
    1,
    NULL,
    NULL,
    NULL,
    'A',
    15
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Execução de atividade de dimensionamento de projetos, conforme Ordem de Serviço específica e com planejamento previamente aprovado pela Agência',
    '0,5 HST por hora prevista no planejamento',
    0.5,
    NULL,
    NULL,
    NULL,
    'A',
    15
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Refactoring: Melhoria em código existente, não desenvolvido pela contratada, sem alteração de funcionalidade. Ao final, a funcionalidade deve ser documentada e o código deve estar aderente aos critérios de qualidade do contrato.',
    NULL,
    NULL,
    'Será utilizado apenas mediante justificativa. Exemplo: uma nova funcionalidade será desenvolvida, e dependerá de um código pré-existente, que precisa se tornar mais “confiável”.',
    'FI = 50%',
    'Será utilizado apenas mediante justificativa. Exemplo: uma nova funcionalidade será desenvolvida, e dependerá de um código pré-existente, que precisa se tornar mais “confiável”.',
    'A',
    16
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Alterar funcionalidade existente, desenvolvida ou mantida pela contratada.',
    NULL,
    NULL,
    'Fator similar ao Roteiro de Métricas do SISP v2.2',
    'FI = 50%',
    'Fator similar ao Roteiro de Métricas do SISP v2.2',
    'A',
    16
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Alterar funcionalidade existente, não desenvolvida ou mantida pela contratada.',
    NULL,
    NULL,
    'Fator similar ao Roteiro de Métricas do SISP v2.2',
    'FI = 75%',
    'Fator similar ao Roteiro de Métricas do SISP v2.2',
    'A',
    16
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Alterar funcionalidade existente, não desenvolvida ou mantida pela contratada, com necessidade de documentação e Refactoring.',
    NULL,
    NULL,
    'Ao final, o código deve estar aderente aos critérios de qualidade do contrato. FI = 90% representa a adição de 15% ao Fator de Impacto anterior (75%), em decorrência do refactoring.',
    'FI = 90%',
    'Ao final, o código deve estar aderente aos critérios de qualidade do contrato. FI = 90% representa a adição de 15% ao Fator de Impacto anterior (75%), em decorrência do refactoring.',
    'A',
    16
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Exclusão de Funcionalidade',
    NULL,
    NULL,
    'Fator similar ao Roteiro de Métricas do SISP v2.2. Inclui o mapeamento dos efeitos gerados pela exclusão em outros pontos do código.',
    'FI = 30%',
    'Fator similar ao Roteiro de Métricas do SISP v2.2. Inclui o mapeamento dos efeitos gerados pela exclusão em outros pontos do código.',
    'A',
    16
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Análise, testes e debug para identificar causa de problema ou defeito em módulos do sistema não desenvolvidos ou mantidos pela contratada. O resultado desta atividade poderá ser:
1) Problema resolvido;
2) Problema não resolvido, mas diagnóstico feito;
3) Problema não resolvido, e causa não identificada. Neste caso, pode-se autorizar nova análise exploratória, mediante a devida justificativa.',
    NULL,
    NULL,
    'Deverá incluir descrição das atividades realizadas para o pagamento.
O padrão é ‘Simples’. Será considerado Complexo quando: não há causa aparente, é intermitente, ou em fronteiras com outros sistemas/infraestrutura.',
    'Problema Simples: 2 HST
Problema Complexo: 6 HST',
    'Deverá incluir descrição das atividades realizadas para o pagamento.
O padrão é ‘Simples’. Será considerado Complexo quando: não há causa aparente, é intermitente, ou em fronteiras com outros sistemas/infraestrutura.',
    'A',
    20
);

INSERT INTO tb_tarefa (
    id, nome, desc_hst_ref, vl_hst_ref, detalhe, fator_impacto, mem_calculo, status, disciplina_id
) VALUES (
    nextval('tb_tarefa_seq'),
    'Estudo de código legado (não desenvolvido pela contratada), para posterior manutenção e/ou evolução.',
    NULL,
    NULL,
    'Deve resultar numa apresentação (com documentação auxiliar) de como as funcionalidades do sistema estão organizadas no código, incluindo dados técnicos e de negócio. Deve apontar, se for o caso, pontos do código com necessidade de Refatoração.',
    '1,5 HST por Entidade mapeada no código fonte',
    'Deve resultar numa apresentação (com documentação auxiliar) de como as funcionalidades do sistema estão organizadas no código, incluindo dados técnicos e de negócio. Deve apontar, se for o caso, pontos do código com necessidade de Refatoração.',
    'A',
    21
);