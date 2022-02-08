CREATE SEQUENCE seq_medicao;
CREATE TABLE tb_medicao(
	id bigint NOT NULL,
	fk_obra_contrato bigint NOT NULL,
	numero_boletim_medicao varchar(100) NOT NULL,
	andamento bigint NOT NULL,
	tipo_medicao bigint NOT NULL,
	valor_medido numeric(19, 2) NOT NULL,
	perc_fisico_executado numeric(19, 2) NOT NULL,
	data_medicao date NOT NULL,
	data_inicio_medicao date NOT NULL,
	data_fim_medicao date NOT NULL,
	info_adicionais varchar(255) NULL,
	PRIMARY KEY (id)
);

CREATE SEQUENCE seq_anexo;
CREATE TABLE tb_anexo(
	id bigint NOT NULL,
	"path" varchar(255) NOT NULL,
	tipo_anexo bigint NOT NULL,
	fk_obra bigint NULL,
	fk_medicao bigint NULL,
	PRIMARY KEY (id)
);

CREATE SEQUENCE seq_obra_contrato;
CREATE TABLE tb_obra_contrato (
	id bigint NOT NULL,
	fk_obra bigint NOT NULL,
	fk_contrato bigint NOT NULL,
	PRIMARY KEY (id)
);

CREATE SEQUENCE seq_orgao;
CREATE TABLE tb_orgao(
	id bigint NOT NULL,
	nome varchar(255) NOT NULL,
	codigo varchar(100) NOT NULL,
	sigla varchar(20) NOT NULL,
	ativo boolean NOT NULL,	
	PRIMARY KEY (id)
);

CREATE SEQUENCE seq_empenho;
CREATE TABLE tb_empenho (
	id bigint NOT NULL,
	exercicio bigint NOT NULL,
	numero varchar(100) NOT NULL,
	valor numeric(19, 2) NOT NULL,
	fk_orgao_unidade_gestora bigint NOT NULL,
	fk_medicao bigint NOT NULL,
	PRIMARY KEY (id)    
);

CREATE SEQUENCE seq_empresa;
CREATE TABLE public.tb_empresa (
	id bigint NOT NULL,
	nome varchar(255) NOT NULL,
	cnpj varchar(15) NOT NULL,
	ativo boolean NOT NULL,
	PRIMARY KEY (id)
);

CREATE SEQUENCE seq_acao;
CREATE TABLE public.tb_acao (
	id bigint NOT NULL,
	descricao varchar(255) NOT NULL,
	ano bigint NOT NULL,
	codigo varchar(100) NOT NULL,
	ativo boolean NOT NULL,
	PRIMARY KEY (id)
);

CREATE SEQUENCE seq_programa;
CREATE TABLE public.tb_programa (
	id bigint NOT NULL,
	descricao varchar(255) NOT NULL,
	ano bigint NOT NULL,
	codigo varchar(100) NOT NULL,
	ativo boolean NOT NULL,
	PRIMARY KEY (id)
);

CREATE SEQUENCE seq_contrato;
CREATE TABLE public.tb_contrato (
	id bigint NOT NULL,
	registro_cge varchar(150)  NULL,
	objeto varchar(255) NOT NULL,
	exercicio bigint NOT NULL,
	data_inicio_vigencia date NOT NULL,
	data_fim_vigencia date NULL,
	valor_contratado numeric(19, 2) NOT NULL,
	valor_atual numeric(19, 2) NOT NULL,
	contrato_orgao varchar(100) NOT NULL,
	valor_aditivos numeric(19, 2) NULL,
	data_fim_vigencia_adtivo date NULL,
	modalidade_licitacao bigint NOT NULL,
	numero_licitacao varchar(100) NULL,
	classificacao_funcional varchar(255) NULL,
	tipo_identificacao_convenio bigint NOT NULL,
	numero_convenio varchar(100) NULL,
	observacao varchar(255) NULL,
	pac boolean NOT NULL,
	fk_programa bigint NOT NULL,
	fk_acao bigint NOT NULL,
	funcao bigint NOT NULL,
	fk_orgao_contratante bigint NOT NULL,
	fk_orgao_demandante bigint NOT NULL,
	fk_empresa bigint NOT NULL,
	fk_municipio bigint NOT NULL,
	PRIMARY KEY (id)
);

CREATE SEQUENCE seq_contrato_fonte_recurso;
CREATE TABLE public.tb_contrato_fonte_recurso (
	id bigint NOT NULL,
	fk_contrato bigint NOT NULL,
	fonte_recurso bigint NOT NULL,
	PRIMARY KEY (id)
);

CREATE SEQUENCE seq_complexo;
CREATE TABLE public.tb_complexo (
	id bigint NOT NULL,
	descricao varchar(255) NOT NULL,
	ativo boolean NOT NULL,
	PRIMARY KEY (id)
);

CREATE SEQUENCE seq_obra;
CREATE TABLE public.tb_obra (
	id bigint NOT NULL,
	fk_complexo bigint NOT NULL,
	tipo_obra bigint NOT NULL,
	categoria_obra bigint NOT NULL,
	unidade_medida bigint NOT NULL,
	situacao bigint NOT NULL,
	nome varchar(255) NOT NULL,
	fk_orgao_executor bigint NOT NULL,
	fk_orgao_demandante bigint NOT NULL,
	matricula_cei bigint NULL,
	dimensao_inicial numeric(19, 2) NOT NULL,
	data_inicio date NOT NULL,
	data_previsao_conclusao date NULL,
	perc_fisico_executado numeric(19, 2) NULL,
	data_ultimo_registro_execucao date NULL,
	fk_municipio bigint NOT NULL,
	logradouro varchar(255) NOT NULL,
	bairro varchar(100) NOT NULL,
	cep bigint NOT NULL,
	referencia_endereco varchar(255) NULL,
	valor_inicial numeric(19, 2) NOT NULL,
	forma_geoferenciamento bigint NOT NULL,
	georeferencimento_atual varchar(150) NOT NULL,
	data_ordem_servico date NULL,
	PRIMARY KEY (id)
);

CREATE SEQUENCE seq_municipios_adicionais;
CREATE TABLE public.tb_municipios_adicionais (
	id bigint NOT NULL,
	fk_obra bigint NOT NULL,
	fk_municipio bigint NOT NULL,
	PRIMARY KEY (id)
);

CREATE SEQUENCE seq_municipio;
CREATE TABLE public.tb_municipio (
	id bigint NOT NULL,
	nome varchar(100) NOT NULL,
	nome_dados varchar(100) NOT NULL,
	uf bigint NOT NULL,
	codigo varchar(100) NOT NULL,
	ativo boolean NOT NULL,
	PRIMARY KEY (id)
);

CREATE SEQUENCE seq_responsavel;
CREATE TABLE public.tb_responsavel (
	id bigint NOT NULL,
	fk_obra bigint NOT NULL,
	registro varchar(100) NULL,
	nome varchar(255) NOT NULL,
	profissao bigint NOT NULL,
	registro_crea varchar(100) NULL,
	registro_art varchar(100) NULL,
	responsabilidade bigint NOT NULL,
	fiscal_obra boolean NOT NULL,
	PRIMARY KEY (id)
);

ALTER TABLE tb_medicao ADD CONSTRAINT medicao_obra_contrato_fkey FOREIGN KEY (fk_obra_contrato) REFERENCES tb_obra_contrato(id);

ALTER TABLE tb_anexo ADD CONSTRAINT anexo_obra_fkey FOREIGN KEY (fk_obra) REFERENCES tb_obra(id);

ALTER TABLE tb_anexo ADD CONSTRAINT anexo_medicao_fkey FOREIGN KEY (fk_medicao) REFERENCES tb_medicao(id);

ALTER TABLE tb_obra_contrato ADD CONSTRAINT obra_contrato_obra_fkey FOREIGN KEY (fk_obra) REFERENCES tb_obra(id);

ALTER TABLE tb_obra_contrato ADD CONSTRAINT obra_contrato_contrato_fkey FOREIGN KEY (fk_contrato) REFERENCES tb_contrato(id);

ALTER TABLE tb_empenho ADD CONSTRAINT empenho_orgao_fkey FOREIGN KEY (fk_orgao_unidade_gestora) REFERENCES tb_orgao(id);

ALTER TABLE tb_empenho ADD CONSTRAINT empenho_medicao_fkey FOREIGN KEY (fk_medicao) REFERENCES tb_medicao (id);

ALTER TABLE tb_contrato ADD CONSTRAINT contrato_programa_fkey FOREIGN KEY (fk_programa) REFERENCES tb_programa(id);

ALTER TABLE tb_contrato ADD CONSTRAINT contrato_acao_fkey FOREIGN KEY (fk_acao) REFERENCES tb_acao(id);

ALTER TABLE tb_contrato ADD CONSTRAINT contrato_orgao_contratante_fkey FOREIGN KEY (fk_orgao_contratante) REFERENCES tb_orgao(id);

ALTER TABLE tb_contrato ADD CONSTRAINT contrato_orgao_demandante_fkey FOREIGN KEY (fk_orgao_demandante) REFERENCES tb_orgao(id);

ALTER TABLE tb_contrato ADD CONSTRAINT contrato_empresa_fkey FOREIGN KEY (fk_empresa) REFERENCES tb_empresa (id);

ALTER TABLE tb_contrato ADD CONSTRAINT contrato_municipio_fkey FOREIGN KEY (fk_municipio) REFERENCES tb_municipio (id);

ALTER TABLE tb_contrato_fonte_recurso ADD CONSTRAINT contrato_fonte_recurso_contrato_fkey FOREIGN KEY (fk_contrato) REFERENCES tb_contrato (id);

ALTER TABLE tb_obra ADD CONSTRAINT obra_complexo_fkey FOREIGN KEY (fk_complexo) REFERENCES tb_complexo (id);

ALTER TABLE tb_obra ADD CONSTRAINT obra_orgao_executor_fkey FOREIGN KEY (fk_orgao_executor) REFERENCES tb_orgao (id);

ALTER TABLE tb_obra ADD CONSTRAINT obra_orgao_demandante_fkey FOREIGN KEY (fk_orgao_demandante) REFERENCES tb_orgao (id);

ALTER TABLE tb_obra ADD CONSTRAINT obra_municipio_fkey FOREIGN KEY (fk_municipio) REFERENCES tb_municipio (id);

ALTER TABLE tb_municipios_adicionais ADD CONSTRAINT municipio_adicionais_obra_fkey FOREIGN KEY (fk_obra) REFERENCES tb_obra (id);

ALTER TABLE tb_municipios_adicionais ADD CONSTRAINT municipio_adicionais_municipio_fkey FOREIGN KEY (fk_municipio) REFERENCES tb_municipio (id);

ALTER TABLE tb_responsavel ADD CONSTRAINT responsavel_obra_fkey FOREIGN KEY (fk_obra) REFERENCES tb_obra (id);

