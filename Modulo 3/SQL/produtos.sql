CREATE DATABASE produtos;
USE produtos;

CREATE TABLE categoria(
	id_categoria INT NOT NULL IDENTITY(1, 1),
	nome VARCHAR(255),
	ativa CHAR(3)
	PRIMARY KEY(id_categoria)
);

INSERT INTO categoria(nome, ativa) VALUES
	('Informatica','[v]'),
	('Telefonia','[v]'),
	('Games','[v]'),
	('TV, Audio e Video','[v]'),
	('Impressão e imagem','[v]');

CREATE TABLE produto(
	id_produto INT NOT NULL IDENTITY(1, 1),
	id_categoria INT,
	descricao VARCHAR(255),
	preco INT,
	url_imagem VARCHAR(255)
	PRIMARY KEY(id_produto)
);

INSERT INTO produto(id_categoria, descricao, preco) VALUES
	(1,'SSD 128GB', 300),
	(1,'SSD 256GB', 500),
	(1,'KIT TECLADO E MOUSE', 600),
	(3,'PLAYSTATION 3', 1500),
	(2,'SAMSUNG A51', 2500),
	(4,'TELEVISÃO LG 55"', 3000),
	(3,'PLAYSTATION 3 1TB', 1500),
	(2,'SAMSUNG S9', 2500),
	(2,'IPHONE 8', 2500),
	(2,'IPHONE 9', 3000),
	(2,'IPHONE X', 4000),
	(4,'TELEVISÃO SAMSUNG 32"', 1000),
	(4,'TELEVISÃO SAMSUNG 48"', 3000),
	(3,'PLAYSTATION 4 1TB', 2800),
	(3,'PLAYSTATION 5 1TB', 5000),
	(1,'Teclado Razer Gamer', 250),
	(1,'Fone de ouvido Hyperx',170),
	(1,'Mouse Gamer Razer', 90),
	(1,'Mouse Gamer Razer 2400', 200);

INSERT INTO produto(descricao, preco) VALUES
	('Mouse Gamer', 280),
	('Teclado Gamer', 390);

-- Produtos com categoria (intersecção -> inner join)
SELECT produto.descricao AS descricao,
	categoria.nome AS categoria
FROM produto
	INNER JOIN categoria ON produto.id_categoria = categoria.id_categoria;

-- Todos os produtos com categoria, se houver (left join)
SELECT produto.descricao AS descricao,
	categoria.nome AS categoria
FROM produto
	LEFT JOIN categoria ON produto.id_categoria = categoria.id_categoria;

-- Todas as categorias, mesmo sem produto (right join)
SELECT produto.descricao AS descricao,
	categoria.nome AS categoria
FROM produto
	RIGHT JOIN categoria ON produto.id_categoria = categoria.id_categoria;

-- 
SELECT MAX(produto.preco) AS preco,
	categoria.nome AS nome
FROM produto
	INNER JOIN categoria ON produto.id_categoria = categoria.id_categoria
GROUP BY categoria.nome;

-- Menor e maior preço do produto da categoria game e telefonia
SELECT MAX(produto.preco) AS preco_maximo, 
	MIN(produto.preco) AS preco_minimo, 
	categoria.nome AS categoria
FROM produto 
	INNER JOIN categoria ON produto.id_categoria = categoria.id_categoria
WHERE categoria.id_categoria = 3 OR categoria.id_categoria = 1
GROUP BY categoria.nome;

-- Quanto custa o maior produto não catalogado
SELECT MAX(produto.preco) AS preco
FROM produto
	LEFT JOIN categoria ON produto.id_categoria = categoria.id_categoria
WHERE produto.id_categoria IS NULL;

-- Média de preço por categoria
SELECT categoria.nome AS categoria,
	AVG(produto.preco) AS media
FROM produto
	LEFT JOIN categoria ON produto.id_categoria = categoria.id_categoria
GROUP BY categoria.nome;

-- Soma das televisoes e video games que tem preço maior que 1500
SELECT SUM(produto.preco) AS valor_soma, 
	categoria.nome AS categoria
FROM produto 
	INNER JOIN categoria ON produto.id_categoria = categoria.id_categoria
WHERE (categoria.id_categoria = 3
	OR categoria.id_categoria = 4)
	AND produto.preco > 1500
GROUP BY categoria.nome;

-- Mouse mais caro
SELECT TOP 1 categoria.nome AS categoria,
	produto.descricao AS produto,
	produto.preco AS preco
FROM produto
	INNER JOIN categoria ON produto.id_categoria = categoria.id_categoria
WHERE produto.descricao LIKE '%Mouse%'
ORDER BY produto.preco DESC;
