
-- SQL schema para o projeto jpa_hibernate
-- Cria as tabelas 'pessoa' e 'produto' com constraints compatíveis com as entidades Java
-- Este arquivo usa sintaxe MySQL (AUTO_INCREMENT). Para PostgreSQL, substitua por SERIAL/SEQUENCE.

-- --------------------------------------------------
-- Tabela: pessoa
-- --------------------------------------------------
DROP TABLE IF EXISTS pessoa;
CREATE TABLE pessoa (
	id BIGINT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	idade INT NULL,
	cpf VARCHAR(20) NOT NULL,
	data_nascimento DATE NULL,
	PRIMARY KEY (id),
	UNIQUE KEY uk_pessoa_cpf (cpf)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------
-- Tabela: produto
-- --------------------------------------------------
DROP TABLE IF EXISTS produto;
CREATE TABLE produto (
	id BIGINT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL,
	quantidade INT NULL,
	preco DECIMAL(10,2) NULL,
	status TINYINT(1) NULL DEFAULT 1,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------
-- Dados de exemplo
-- --------------------------------------------------
INSERT INTO pessoa (nome, email, idade, cpf, data_nascimento) VALUES
('João Silva', 'joao.silva@example.com', 30, '123.456.789-00', '1995-01-15'),
('Maria Santos', 'maria.santos@example.com', 28, '987.654.321-00', '1997-04-20');

INSERT INTO produto (nome, quantidade, preco, status) VALUES
('Caneta Azul', 100, 1.50, 1),
('Caderno 100 folhas', 50, 12.90, 1),
('Estojo', 0, 8.00, 0);

-- Observações:
-- - Ajuste tipos e tamanho de colunas conforme necessidade.
-- - Para PostgreSQL, altere AUTO_INCREMENT -> SERIAL (ex.: id BIGSERIAL) e TINYINT(1) -> BOOLEAN.
-- - Se preferir um banco em memória (H2) para testes rápidos, configure o 'persistence.xml' adequadamente.
