CREATE DATABASE veiculos;
USE veiculos;

CREATE TABLE categoria(
	id_categoria INT NOT NULL IDENTITY(1, 1),
	descricao VARCHAR(255) NOT NULL,
	PRIMARY KEY(id_categoria)
);

CREATE TABLE veiculo(
	id_veiculo INT NOT NULL IDENTITY(1, 1),
	id_categoria INT NOT NULL,
	marca VARCHAR(255) NOT NULL,
	modelo VARCHAR(255) NOT NULL,
	ano DATE NOT NULL,
	PRIMARY KEY(id_veiculo),
	FOREIGN KEY(id_categoria) REFERENCES categoria(id_categoria)
);

CREATE TABLE responsavel(
	id_responsavel INT NOT NULL IDENTITY(1, 1),
	nome VARCHAR(255) NOT NULL,
	PRIMARY KEY(id_responsavel)
);

CREATE TABLE historico(
	id_historico INT NOT NULL IDENTITY(1, 1),
	id_responsavel INT NOT NULL,
	id_veiculo INT NOT NULL,
	data_inicio DATE NOT NULL,
	data_fim DATE,
	PRIMARY KEY(id_historico),
	FOREIGN KEY(id_responsavel) REFERENCES responsavel(id_responsavel),
	FOREIGN KEY(id_veiculo) REFERENCES veiculo(id_veiculo)
);

INSERT INTO categoria(descricao) VALUES('Carro');
INSERT INTO categoria(descricao) VALUES('Caminhonete');
INSERT INTO categoria(descricao) VALUES('Caminhão');

INSERT INTO veiculo(id_categoria, marca, modelo, ano) VALUES(1, 'Fiat', 'Uno', '01/01/2000');
INSERT INTO veiculo(id_categoria, marca, modelo, ano) VALUES(2, 'Tesla', 'Cybertruck', '01/01/2023');
INSERT INTO veiculo(id_categoria, marca, modelo, ano) VALUES(3, 'Mercedes Benz', 'Arocs', '01/01/2021');

INSERT INTO responsavel(nome) VALUES('João');
INSERT INTO responsavel(nome) VALUES('Maria');
INSERT INTO responsavel(nome) VALUES('José');

INSERT INTO historico(id_responsavel, id_veiculo, data_inicio) VALUES(1, 1, CONVERT(DATE, GETDATE()));
INSERT INTO historico(id_responsavel, id_veiculo, data_inicio) VALUES(2, 2, CONVERT(DATE, GETDATE()));
INSERT INTO historico(id_responsavel, id_veiculo, data_inicio) VALUES(3, 3, CONVERT(DATE, GETDATE()));

SELECT responsavel.nome AS responsavel,
	categoria.descricao AS categoria,
	veiculo.marca, 
	veiculo.modelo, 
	veiculo.ano 
FROM historico 
	INNER JOIN responsavel ON historico.id_responsavel = responsavel.id_responsavel 
	INNER JOIN veiculo ON historico.id_veiculo = veiculo.id_categoria
	INNER JOIN categoria ON veiculo.id_categoria = categoria.id_categoria
