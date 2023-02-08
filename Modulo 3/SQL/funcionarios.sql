CREATE DATABASE clientes_db;
USE clientes_db;

CREATE TABLE cliente(
	id_cliente INT NOT NULL IDENTITY(1, 1),
	nome VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	cpf CHAR(11) NOT NULL,
	sexo CHAR(1) NOT NULL,
	idade INT NOT NULL,
	PRIMARY KEY(id_cliente),
);

INSERT INTO cliente(nome, email, idade, sexo, cpf) VALUES ('Robson', 'email@email.com', 40,'M', '12312312312');
INSERT INTO cliente(nome, email, idade, sexo, cpf) VALUES ('Denise', 'email@email.com', 35,'F', '18989888812');
INSERT INTO cliente(nome, email, idade, sexo, cpf) VALUES ('Madalena', 'email@email.com', 55,'F', '34534534545');
INSERT INTO cliente(nome, email, idade, sexo, cpf) VALUES ('Jorge', 'email@email.com', 60, 'M', '89089089090');
INSERT INTO cliente(nome, email, idade, sexo, cpf) VALUES ('Ana', 'email@email.com', 18, 'F','90909009090');
INSERT INTO cliente(nome, email, idade, sexo, cpf) VALUES ('Bruna', 'email@email.com', 26, 'F','78568945239');

SELECT nome, idade, sexo 
FROM cliente 
WHERE sexo = 'F'
	AND idade > 30
ORDER BY idade DESC;

CREATE TABLE departamento(
	id_departamento INT NOT NULL IDENTITY(1, 1),
	nome VARCHAR(255) NOT NULL
	PRIMARY KEY(id_departamento)
);

CREATE TABLE funcionario(
	id_funcionario INT NOT NULL IDENTITY(1, 1),
	id_departamento  INT NOT NULL,
	nome VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	salario INT NOT NULL,
	data_nascimento DATE NOT NULL,
	sexo CHAR(1) NOT NULL
	PRIMARY KEY(id_funcionario)
	FOREIGN KEY(id_departamento) REFERENCES departamento(id_departamento)
);

INSERT INTO departamento(nome) VALUES('Vendas'), 
	('Marketing'), 
	('RH'), 
	('TI'), 
	('Administrativo'), 
	('Desenvolvimento');

INSERT INTO funcionario(nome, email, sexo, data_nascimento, salario, id_departamento) VALUES
	('Luana', 'luana@gmail.com', 'F', '01-05-1996', 3000, 1),
	('Marilia', 'marilia@hotmail.com', 'F', '03-05-1995', 3100, 2),
	('Raquel', 'raquel@gmail.com', 'F', '15-07-1994', 3050, 3),
	('Joana', 'joana@gmail.com', 'F', '03-07-1995', 3000, 4),
	('Fabricio', 'fabricio@gmail.com', 'M', '01-05-1993', 4700, 5),
	('Everaldo', 'everaldo@hotmail.com', 'M', '07-05-1993', 4600, 6),
	('Ricardo', 'ricardo@gmail.com', 'M', '15-05-1998', 3500, 1),
	('Cleber', 'cleber@hotmail.com', 'M', '01-05-1997', 3300, 3),
	('Fernando', 'fernando@hotmail.com', 'M', '03-05-1989', 3000, 2),
	('Felipe', 'felipe@hotmail.com', 'M', '03-05-1996', 3070, 4),
	('Matheus', 'matheus@hotmail.com', 'M', '15-05-1989', 4060, 5),
	('Rodrigo', 'rodrigo@hotmail.com', 'M', '01-05-1996', 3060, 6),
	('Luma', 'luma@gmail.com', 'F', '01-05-1996', 3700, 1),
	('Rafael', 'rafael@gmail.com', 'M', '15-03-1991', 3500, 4),
	('Mariana', 'mariana@gmail.com', 'F', '01-07-1998', 3900, 4),
	('Monique', 'monique@gmail.com', 'F', '15-07-1993', 4100, 2),
	('Joaquim', 'joaquim@hotmail.com', 'M', '01-05-1994', 3300, 3),
	('Sandro', 'sandro@gmail.com', 'M', '01-05-1996', 4700, 5),
	('Henrique', 'henrique@gmail.com', 'M', '07-07-1995', 3500, 6),
	('Maria', 'maria@gmail.com', 'F', '07-07-1995', 4100, 3),
	('Penha', 'penha@gmail.com', 'F', '07-07-1988', 5000, 5),
	('Laura', 'laura@gmail.com', 'F', '07-07-1990', 5500, 5);

SELECT funcionario.nome, funcionario.salario, departamento.nome AS departament FROM funcionario INNER JOIN departamento ON funcionario.id_departamento = departamento.id_departamento WHERE funcionario.salario >= 3000;

SELECT nome, data_nascimento FROM funcionario ORDER BY data_nascimento DESC;

SELECT AVG(salario) AS media_salarial FROM funcionario;

-- Salário por departamento
SELECT departamento.nome AS departamento,
	COUNT(funcionario.id_funcionario) AS funcionarios,
	MIN(funcionario.salario) AS  minimo,
	MAX(funcionario.salario) AS maximo
FROM funcionario 
	INNER JOIN departamento ON funcionario.id_departamento = departamento.id_departamento  
GROUP BY departamento.nome;

-- Salário por sexo
SELECT sexo, 
	AVG(salario) AS media, 
	COUNT(id_funcionario) AS funcionarios 
FROM funcionario
GROUP BY sexo;

-- Salário
SELECT COUNT(funcionario.id_funcionario) AS funcionarios,
	funcionario.id_departamento AS departamento
FROM funcionario
WHERE funcionario.sexo = 'M' AND funcionario.salario > 3800
GROUP BY funcionario.id_departamento
HAVING COUNT(funcionario.id_funcionario) > 1;

--Crie uma view que traga o nome do departamento, sexo dos funcionarios
-- e a contagem dos funcionarios
-- Contudo, apenas os departamentos que tenham a letra 'd' e seus respectivos funcionarios 
--sejam mulheres que usam gmail e homens que usam hotmail
--Alem disso, a contagem de funcionario por sexo e por departamento deve ser maior que 1

CREATE VIEW view_sexo_departamento AS (
	SELECT departamento.nome AS departamento,
	funcionario.sexo AS sexo,
	COUNT(funcionario.id_funcionario) AS funcionarios
	FROM funcionario
		INNER JOIN departamento ON funcionario.id_departamento = departamento.id_departamento
	WHERE departamento.nome LIKE '%d%'
		AND (funcionario.sexo = 'M' AND funcionario.email LIKE '%@hotmail.com' OR funcionario.sexo = 'F' AND funcionario.email LIKE '%@gmail.com')
	GROUP BY departamento.nome, funcionario.sexo
	HAVING COUNT(funcionario.id_funcionario) > 1
);

SELECT * FROM view_sexo_departamento;
