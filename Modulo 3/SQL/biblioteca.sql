CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE endereco(
	id_endereco INT NOT NULL IDENTITY(1, 1),
	cidade VARCHAR(255) NOT NULL,
	bairro VARCHAR(255) NOT NULL,
	logradouro VARCHAR(255) NOT NULL,
	numero NUMERIC NOT NULL,
	complemento VARCHAR(255),
	PRIMARY KEY(id_endereco)
);

CREATE TABLE usuario(
	id_usuario INT NOT NULL IDENTITY(1, 1),
	id_endereco INT NOT NULL,
	nome VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	professor BIT NOT NULL,
	PRIMARY KEY(id_usuario),
	FOREIGN KEY(id_endereco) REFERENCES endereco(id_endereco)
);

CREATE TABLE curso(
	id_curso INT NOT NULL IDENTITY(1, 1),
	nome VARCHAR(255) NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	data_inicio DATE NOT NULL,
	data_fim DATE NOT NULL,
	PRIMARY KEY(id_curso),
);

CREATE TABLE inscricao(
	id_inscricao INT NOT NULL IDENTITY(1, 1),
	id_usuario INT NOT NULL,
	id_curso INT NOT NULL,
	PRIMARY KEY(id_inscricao),
	FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
	FOREIGN KEY(id_curso) REFERENCES curso(id_curso)
);

CREATE TABLE classificacao(
	id_classificacao INT NOT NULL IDENTITY(1, 1),
	nome VARCHAR(255) NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	PRIMARY KEY(id_classificacao)
);

CREATE TABLE obra(
	id_obra INT NOT NULL IDENTITY(1, 1),
	id_classificacao INT NOT NULL,
	nome VARCHAR(255) NOT NULL,
	idioma VARCHAR(255) NOT NULL,
	midia VARCHAR(255) NOT NULL,
	PRIMARY KEY(id_obra),
	FOREIGN KEY(id_classificacao) REFERENCES classificacao(id_classificacao)
);

CREATE TABLE autor(
	id_autor INT NOT NULL IDENTITY(1, 1),
	nome VARCHAR(255) NOT NULL,
	nacionalidade VARCHAR(255) NOT NULL,
	PRIMARY KEY(id_autor)
);

CREATE TABLE editora(
	id_editora INT NOT NULL IDENTITY(1, 1),
	nome VARCHAR(255) NOT NULL,
	PRIMARY KEY(id_editora)
);

CREATE TABLE publicacao(
	id_publicacao INT NOT NULL IDENTITY(1, 1),
	id_editora INT NOT NULL,
	id_autor INT NOT NULL,
	id_obra INT NOT NULL,
	ano DATE NOT NULL,
	PRIMARY KEY(id_publicacao),
	FOREIGN KEY(id_editora) REFERENCES editora(id_editora),
	FOREIGN KEY(id_autor) REFERENCES autor(id_autor),
	FOREIGN KEY(id_obra) REFERENCES obra(id_obra)
);

CREATE TABLE emprestimo(
	id_emprestimo INT NOT NULL IDENTITY(1, 1),
	id_usuario INT NOT NULL,
	id_obra INT NOT NULL,
	data_inicio DATE NOT NULL,
	data_fim DATE NOT NULL,
	PRIMARY KEY(id_emprestimo),
	FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
	FOREIGN KEY(id_obra) REFERENCES obra(id_obra)
);

INSERT INTO endereco(cidade, bairro, logradouro, numero, complemento) VALUES('Serra', 'José de Anchieta III', 'Rua Belém', 47, 'Bloco A');
INSERT INTO endereco(cidade, bairro, logradouro, numero, complemento) VALUES('Teresina', 'Parque Ideal', 'Rua Sete', 52, 'Bloco B');
INSERT INTO endereco(cidade, bairro, logradouro, numero, complemento) VALUES('Porto Velho', 'Centro', 'Rua Afonso Pena', 13, 'Bloco C');

INSERT INTO usuario(id_endereco, nome, email, professor) VALUES(1, 'João', 'joao@email.com', 1);
INSERT INTO usuario(id_endereco, nome, email, professor) VALUES(2, 'Maria', 'maria@email.com', 0);
INSERT INTO usuario(id_endereco, nome, email, professor) VALUES(3, 'José', 'jose@email.com', 0);

INSERT INTO curso(nome, descricao, data_inicio, data_fim) VALUES('Java', 'Curso completo de Java', '28/01/2023', '28/05/2023');
INSERT INTO curso(nome, descricao, data_inicio, data_fim) VALUES('Python', 'Curso completo de Python', '28/01/2023', '28/05/2023');
INSERT INTO curso(nome, descricao, data_inicio, data_fim) VALUES('TypeScript', 'Curso completo de TypeScript', '28/01/2023', '28/05/2023');

INSERT INTO inscricao(id_usuario, id_curso) VALUES(1, 1);
INSERT INTO inscricao(id_usuario, id_curso) VALUES(1, 2);
INSERT INTO inscricao(id_usuario, id_curso) VALUES(1, 3);
INSERT INTO inscricao(id_usuario, id_curso) VALUES(2, 2);
INSERT INTO inscricao(id_usuario, id_curso) VALUES(3, 3);

INSERT INTO classificacao(nome, descricao) VALUES('Científico', 'Livros científicos');
INSERT INTO classificacao(nome, descricao) VALUES('Informatico', 'Livros informativos');
INSERT INTO classificacao(nome, descricao) VALUES('Entretenimento', 'Livros entretenimentos');

INSERT INTO obra(id_classificacao, nome, idioma, midia) VALUES(1, 'Os elementos de Euclides', 'Português', 'Livro');
INSERT INTO obra(id_classificacao, nome, idioma, midia) VALUES(2, 'Os Números Não Mentem', 'Português', 'Livro');
INSERT INTO obra(id_classificacao, nome, idioma, midia) VALUES(3, 'E Se?', 'Português', 'Livro');

INSERT INTO autor(nome, nacionalidade) VALUES('David Berlinski', 'Estados Unidos');
INSERT INTO autor(nome, nacionalidade) VALUES('Randall Patrick', 'Estados Unidos');
INSERT INTO autor(nome, nacionalidade) VALUES('Václav Smil', 'Tchéquia');

INSERT INTO editora(nome) VALUES('Grupo Companhia das Letras');
INSERT INTO editora(nome) VALUES('Editora Intrínseca Ltda.');

INSERT INTO publicacao(id_editora, id_autor, id_obra, ano) VALUES(1, 1, 1, '22/02/2018');
INSERT INTO publicacao(id_editora, id_autor, id_obra, ano) VALUES(2, 3, 2, '10/11/2021');
INSERT INTO publicacao(id_editora, id_autor, id_obra, ano) VALUES(1, 2, 3, '01/01/2014');

INSERT INTO emprestimo(id_usuario, id_obra, data_inicio, data_fim) VALUES(1, 1, '01/01/2023', '01/04/2023');
INSERT INTO emprestimo(id_usuario, id_obra, data_inicio, data_fim) VALUES(2, 2, '01/01/2023', '01/04/2023');
INSERT INTO emprestimo(id_usuario, id_obra, data_inicio, data_fim) VALUES(3, 3, '01/01/2023', '01/04/2023');

-- Quais usuários fizeram emprestimo da obra 1
SELECT usuario.nome AS nome,
	obra.nome AS obra
FROM emprestimo
	INNER JOIN usuario ON emprestimo.id_usuario = usuario.id_usuario
	INNER JOIN obra ON emprestimo.id_obra = obra.id_obra
WHERE emprestimo.id_obra = 1;

-- Quais obras o usuário 2 fez emprestimo
SELECT usuario.nome AS nome,
	obra.nome AS obra
FROM emprestimo
	INNER JOIN usuario ON emprestimo.id_usuario = usuario.id_usuario
	INNER JOIN obra ON emprestimo.id_obra = obra.id_obra
WHERE emprestimo.id_usuario = 2;

-- Quais usuários pertencem ao curso 2
SELECT usuario.nome AS aluno,
	curso.nome AS curso
FROM inscricao
	INNER JOIN usuario ON inscricao.id_usuario = usuario.id_endereco
	INNER JOIN curso ON inscricao.id_curso = curso.id_curso
WHERE inscricao.id_curso = 2;

-- Quais cursos o usuário 1 possui
SELECT usuario.nome AS aluno,
	curso.nome AS curso
FROM inscricao
	INNER JOIN usuario ON inscricao.id_usuario = usuario.id_endereco
	INNER JOIN curso ON inscricao.id_curso = curso.id_curso
WHERE inscricao.id_usuario = 1;
