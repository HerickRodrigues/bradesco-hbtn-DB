
-- Schema SQL para o subprojeto java_jpa_hibernate_mapeamento/gestao-cursos-api
-- Compatível com MySQL (InnoDB). Ajuste tipos para PostgreSQL ou H2 conforme necessário.

SET FOREIGN_KEY_CHECKS = 0;

-- remover tabelas existentes (ordem segura)
DROP TABLE IF EXISTS aluno_curso;
DROP TABLE IF EXISTS material_curso;
DROP TABLE IF EXISTS telefone;
DROP TABLE IF EXISTS curso;
DROP TABLE IF EXISTS aluno;
DROP TABLE IF EXISTS endereco;
DROP TABLE IF EXISTS professor;

-- tabela professor
CREATE TABLE professor (
	id BIGINT NOT NULL AUTO_INCREMENT,
	nome_completo VARCHAR(255),
	matricula VARCHAR(255),
	email VARCHAR(255),
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- tabela endereco
CREATE TABLE endereco (
	id BIGINT NOT NULL AUTO_INCREMENT,
	logradouro VARCHAR(255),
	endereco VARCHAR(255),
	numero VARCHAR(50),
	bairro VARCHAR(255),
	cidade VARCHAR(255),
	estado VARCHAR(255),
	cep INT,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- tabela aluno
CREATE TABLE aluno (
	id BIGINT NOT NULL AUTO_INCREMENT,
	nome_completo VARCHAR(255),
	matricula VARCHAR(255),
	nascimento DATE,
	email VARCHAR(255),
	endereco_id BIGINT,
	PRIMARY KEY (id),
	INDEX idx_aluno_endereco (endereco_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- tabela curso
CREATE TABLE curso (
	id BIGINT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(255),
	sigla VARCHAR(255),
	professor_id BIGINT,
	PRIMARY KEY (id),
	INDEX idx_curso_professor (professor_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- tabela material_curso
CREATE TABLE material_curso (
	id BIGINT NOT NULL AUTO_INCREMENT,
	url VARCHAR(1024),
	curso_id BIGINT,
	PRIMARY KEY (id),
	INDEX idx_material_curso (curso_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- tabela telefone
CREATE TABLE telefone (
	id BIGINT NOT NULL AUTO_INCREMENT,
	ddd VARCHAR(10),
	numero VARCHAR(50),
	aluno_id BIGINT,
	PRIMARY KEY (id),
	INDEX idx_telefone_aluno (aluno_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- tabela de associação many-to-many aluno <-> curso
CREATE TABLE aluno_curso (
	curso_id BIGINT NOT NULL,
	aluno_id BIGINT NOT NULL,
	PRIMARY KEY (curso_id, aluno_id),
	INDEX idx_alunocurso_curso (curso_id),
	INDEX idx_alunocurso_aluno (aluno_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- chaves estrangeiras
ALTER TABLE aluno
	ADD CONSTRAINT fk_aluno_endereco FOREIGN KEY (endereco_id) REFERENCES endereco(id) ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE curso
	ADD CONSTRAINT fk_curso_professor FOREIGN KEY (professor_id) REFERENCES professor(id) ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE material_curso
	ADD CONSTRAINT fk_material_curso_curso FOREIGN KEY (curso_id) REFERENCES curso(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE telefone
	ADD CONSTRAINT fk_telefone_aluno FOREIGN KEY (aluno_id) REFERENCES aluno(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE aluno_curso
	ADD CONSTRAINT fk_alunocurso_curso FOREIGN KEY (curso_id) REFERENCES curso(id) ON DELETE CASCADE ON UPDATE CASCADE,
	ADD CONSTRAINT fk_alunocurso_aluno FOREIGN KEY (aluno_id) REFERENCES aluno(id) ON DELETE CASCADE ON UPDATE CASCADE;

SET FOREIGN_KEY_CHECKS = 1;

-- Dados de exemplo
INSERT INTO professor (nome_completo, matricula, email) VALUES
('Ana Pereira', 'PROF001', 'ana.pereira@example.com'),
('Carlos Oliveira', 'PROF002', 'carlos.oliveira@example.com');

INSERT INTO endereco (logradouro, endereco, numero, bairro, cidade, estado, cep) VALUES
('Av. Brasil', 'Av. Brasil, 1000', '1000', 'Centro', 'São Paulo', 'SP', 01000000),
('Rua das Flores', 'Rua das Flores, 200', '200', 'Jardim', 'Rio de Janeiro', 'RJ', 20000000);

INSERT INTO aluno (nome_completo, matricula, nascimento, email, endereco_id) VALUES
('João Silva', 'ALU001', '1995-01-15', 'joao.silva@example.com', 1),
('Maria Santos', 'ALU002', '1997-04-20', 'maria.santos@example.com', 2);

INSERT INTO curso (nome, sigla, professor_id) VALUES
('Introdução à Programação', 'PROG101', 1),
('Banco de Dados', 'BD201', 2);

INSERT INTO material_curso (url, curso_id) VALUES
('https://exemplo.com/material/prog101/slide1.pdf', 1),
('https://exemplo.com/material/bd201/aula1.pdf', 2);

INSERT INTO telefone (ddd, numero, aluno_id) VALUES
('11', '99999-0001', 1),
('21', '98888-0002', 2);

INSERT INTO aluno_curso (curso_id, aluno_id) VALUES
(1, 1),
(2, 1),
(2, 2);

-- Fim do schema
