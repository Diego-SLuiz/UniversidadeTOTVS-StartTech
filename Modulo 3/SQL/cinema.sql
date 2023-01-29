CREATE DATABASE cinema;
USE cinema;

CREATE TABLE sala(
	id_sala INT NOT NULL IDENTITY(1, 1),
	nome VARCHAR(255) NOT NULL,
	capacidade NUMERIC NOT NULL,
	PRIMARY KEY(id_sala),
	UNIQUE(nome)
);

CREATE TABLE categoria(
	id_categoria INT NOT NULL IDENTITY(1, 1),
	nome VARCHAR(255) NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	PRIMARY KEY(id_categoria)
);

CREATE TABLE filme(
	id_filme INT NOT NULL IDENTITY(1, 1),
	id_categoria INT NOT NULL,
	nome_original VARCHAR(255) NOT NULL,
	nome_localizado VARCHAR(255) NOT NULL,
	sinopse VARCHAR(255) NOT NULL,
	diretor VARCHAR(255) NOT NULL,
	ano DATE NOT NULL,
	PRIMARY KEY(id_filme),
	FOREIGN KEY(id_categoria) REFERENCES categoria(id_categoria),
	UNIQUE(nome_original),
	UNIQUE(nome_localizado)
);

CREATE TABLE cartaz(
	id_cartaz INT NOT NULL IDENTITY(1, 1),
	id_filme INT NOT NULL,
	data_inicio DATE NOT NULL,
	data_fim DATE,
	PRIMARY KEY(id_cartaz),
	FOREIGN KEY(id_filme) REFERENCES filme(id_filme)
);

CREATE TABLE sessao(
	id_sessao INT NOT NULL IDENTITY(1, 1),
	id_sala INT NOT NULL,
	id_filme INT NOT NULL,
	horario_inicio DATETIME NOT NULL,
	horario_fim DATETIME NOT NULL,
	PRIMARY KEY(id_sessao),
	FOREIGN KEY(id_sala) REFERENCES sala(id_sala),
	FOREIGN KEY(id_filme) REFERENCES filme(id_filme)
);

CREATE TABLE premio(
	id_premio INT NOT NULL IDENTITY(1, 1),
	nome VARCHAR(255) NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	PRIMARY KEY(id_premio)
);

CREATE TABLE premiacao(
	id_premiacao INT NOT NULL IDENTITY(1, 1),
	id_filme INT NOT NULL,
	id_premio INT NOT NULL,
	ano DATE NOT NULL,
	PRIMARY KEY(id_premiacao),
	FOREIGN KEY(id_filme) REFERENCES filme(id_filme),
	FOREIGN KEY(id_premio) REFERENCES premio(id_premio)
);

INSERT INTO sala(nome, capacidade) VALUES('Sala 1', 30);
INSERT INTO sala(nome, capacidade) VALUES('Sala 2', 30);
INSERT INTO sala(nome, capacidade) VALUES('Sala 3', 30);

INSERT INTO categoria(nome, descricao) VALUES('Ação', 'Filmes de ação');
INSERT INTO categoria(nome, descricao) VALUES('Drama', 'Filmes de drama');
INSERT INTO categoria(nome, descricao) VALUES('Fantasia', 'Filmes de fantasia');

INSERT INTO filme(id_categoria, nome_original, nome_localizado, sinopse, diretor, ano) VALUES(1, 'Terminator 2: Judgment Day', 'O Exterminador do Futuro 2 - O Julgamento Final', 'O jovem John Connor é a chave para a vitória da civilização sobre uma rebelião de robôs do futuro.', 'James Cameron', '30/08/1991');
INSERT INTO filme(id_categoria, nome_original, nome_localizado, sinopse, diretor, ano) VALUES(2, 'Titanic: 20th Anniversary', 'Titanic', 'Um artista pobre e uma jovem rica se conhecem e se apaixonam na fatídica jornada do Titanic, em 1912.', 'James Cameron', '16/01/1998');
INSERT INTO filme(id_categoria, nome_original, nome_localizado, sinopse, diretor, ano) VALUES(3, 'Avatar', 'Avatar', 'No exuberante mundo alienígena de Pandora vivem os Navi, seres que parecem ser primitivos, mas são altamente evoluídos.', 'James Cameron', '18/12/2009');

INSERT INTO premio(nome, descricao) VALUES('Oscar de Melhores Efeitos Visuais', 'Filme com os melhores efeitos visuais');
INSERT INTO premio(nome, descricao) VALUES('Oscar de Melhor Trilha Sonora Original', 'Filme com a melhor trilha sonora original');
INSERT INTO premio(nome, descricao) VALUES('Oscar de Melhor Filme', 'Melhor filme do ano');

INSERT INTO premiacao(id_filme, id_premio, ano) VALUES(1, 1, '01/01/1992');
INSERT INTO premiacao(id_filme, id_premio, ano) VALUES(2, 2, '01/01/1998');
INSERT INTO premiacao(id_filme, id_premio, ano) VALUES(3, 3, '01/01/2010');

INSERT INTO cartaz(id_filme, data_inicio, data_fim) VALUES(1, '29/01/2023', '06/02/2023');
INSERT INTO cartaz(id_filme, data_inicio, data_fim) VALUES(2, '29/01/2023', '06/02/2023');
INSERT INTO cartaz(id_filme, data_inicio) VALUES(3, GETDATE());

INSERT INTO sessao(id_sala, id_filme, horario_inicio, horario_fim) VALUES(1, 3, '29/01/2023 12:00:00', '29/01/2023 15:00:00');
INSERT INTO sessao(id_sala, id_filme, horario_inicio, horario_fim) VALUES(1, 2, '29/01/2023 15:00:00', '29/01/2023 18:00:00' );
INSERT INTO sessao(id_sala, id_filme, horario_inicio, horario_fim) VALUES(2, 1, '29/01/2023 15:00:00', '29/01/2023 18:00:00' );

-- Quais prêmios o filme 1 recebeu
SELECT filme.nome_localizado AS filme,
	premio.nome AS premio
FROM premiacao
	INNER JOIN filme ON premiacao.id_filme = filme.id_filme
	INNER JOIN premio ON premiacao.id_premio = premio.id_premio
WHERE premiacao.id_filme = 1;

-- Quais filmes estão atualmente em cartaz
SELECT filme.nome_localizado AS filme
FROM cartaz
	INNER JOIN filme ON cartaz.id_filme = filme.id_filme
WHERE cartaz.data_fim IS NULL;

-- Quais filmes estão sendo exibidos atualmente
SELECT filme.nome_localizado AS filme,
	sala.nome AS sala
FROM sessao
	INNER JOIN filme ON sessao.id_filme = filme.id_filme
	INNER JOIN sala ON sessao.id_sala = sala.id_sala
WHERE sessao.horario_inicio < GETUTCDATE() AND
	sessao.horario_fim > GETUTCDATE();
