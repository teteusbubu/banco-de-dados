----criação de tabelas------------------------------------------------------------------------------------------


CREATE TABLE "tb_cliente" (
	"cliente_id"	INTEGER,
	"nome"	TEXT NOT NULL,
	"cnh"	TEXT,
	"telefone"	TEXT,
	
	PRIMARY KEY("cliente_id" AUTOINCREMENT)
);

CREATE TABLE "tb_veiculo" (
	"veiculo_id"	INTEGER,
	"modelo"	TEXT NOT NULL,
	"ano"	TEXT NOT NULL,
	"placa"	TEXT NOT NULL,
	"disponibilidade"	TEXT NOT NULL,
	
	PRIMARY KEY("veiculo_id" AUTOINCREMENT)
);

CREATE TABLE "tb_aluguel" (
	"aluguel_id"	INTEGER,
	"cliente_id"	INTEGER,
	"veiculo_id"	INTEGER,
	"data_inicio"	TEXT NOT NULL,
	"data_fim"	TEXT NOT NULL,
	
	CONSTRAINT "cliente_id" FOREIGN KEY("cliente_id") REFERENCES "tb_cliente"("cliente_id"),
	CONSTRAINT "veiculo_id" FOREIGN KEY("veiculo_id") REFERENCES "tb_veiculo"("veiculo_id"),
	PRIMARY KEY ("aluguel_id")
);

-----Dados tabela-----------------------------------------------------------------------------------------

INSERT INTO tb_cliente (nome, cnh, telefone)
VALUES
    ('João da Silva', '12345678901', '(123) 456-7890'),
    ('Maria Santos', '98765432109', '(987) 654-3210'),
    ('Pedro Alves', '56789012345', '(567) 890-1234'),
    ('Ana Pereira', '34567890123', '(345) 678-9012'),
    ('José Oliveira', '89012345678', '(890) 123-4567'),
    ('Mariana Souza', '23456789012', '(234) 567-8901'),
    ('Ricardo Fernandes', '67890123456', '(678) 901-2345'),
    ('Isabela Costa', '45678901234', '(456) 789-0123'),
    ('Luiz Gomes', '78901234567', '(789) 012-3456'),
    ('Clara Santos', '12309876543', '(123) 098-7654'),
    ('Fernando Lima', '21098765432', '(210) 987-6543'),
    ('Juliana Pereira', '43210987654', '(432) 109-8765'),
    ('Antônio Rodrigues', '54321098765', '(543) 210-9876'),
    ('Beatriz Almeida', '87654321098', '(876) 543-2109'),
    ('Lucas Oliveira', '98765432109', '(987) 654-3210');

INSERT INTO tb_veiculo (modelo, ano, placa, disponibilidade)
VALUES
    ('Honda Civic', 2020, 'ABC123', 'disponivel'),
    ('Toyota Corolla', 2019, 'XYZ456', 'disponivel'),
    ('Ford Focus', 2021, 'DEF789', 'disponivel'),
    ('Volkswagen Golf', 2018, 'GHI012', 'alugado'),
    ('Chevrolet Cruze', 2020, 'JKL345', 'disponivel'),
    ('Hyundai Elantra', 2019, 'MNO678', 'alugado'),
    ('Nissan Sentra', 2022, 'PQR901', 'disponivel'),
    ('Kia Optima', 2021, 'STU234', 'alugado'),
    ('Mazda3', 2020, 'VWX567', 'disponivel'),
    ('Subaru Impreza', 2018, 'YZA890', 'disponivel'),
    ('Audi A4', 2021, 'BCD123', 'alugado'),
    ('Mercedes-Benz C-Class', 2019, 'EFG456', 'disponivel'),
    ('BMW 3 Series', 2020, 'HIJ789', 'alugado'),
    ('Lexus ES', 2022, 'KLM012', 'disponivel'),
    ('Tesla Model 3', 2021, 'NOP345', 'disponivel');

	
INSERT INTO tb_aluguel (data_inicio, data_fim, cliente_id, veiculo_id)
VALUES
    ('2023-09-12', '2023-09-15', 1, 15), 
    ('2023-09-13', '2023-09-17', 2, 14),
    ('2023-09-14', '2023-09-18', 3, 13),
    ('2023-09-15', '2023-09-20', 4, 12),
    ('2023-09-16', '2023-09-21', 5, 11),
    ('2023-09-17', '2023-09-22', 6, 10),
    ('2023-09-18', '2023-09-23', 7, 9),
    ('2023-09-19', '2023-09-25', 8, 8),
    ('2023-09-20', '2023-09-26', 9, 7),
    ('2023-09-21', '2023-09-27', 10, 6),
    ('2023-09-22', '2023-09-28', 11, 5),
    ('2023-09-23', '2023-09-29', 12, 4),
    ('2023-09-24', '2023-09-30', 13, 3),
    ('2023-09-25', '2023-10-01', 14, 2),
    ('2023-09-26', '2023-10-02', 15, 1);


--------------------------------------------------------------------------------------------------------------------------
-5
SELECT * FROM tb_cliente WHERE telefone = "12345-6789";

SELECT * FROM tb_cliente WHERE cnh = "12345678901";

SELECT nome,cnh FROM tb_cliente ;

-----------------------------------------------------------------------------------------------------
--6
SELECT * FROM tb_veiculo WHERE ano = "2017";

SELECT * FROM tb_veiculo WHERE veiculo_id = "2";

SELECT * FROM tb_veiculo WHERE disponibilidade = "alugado";
---------------------------------------------------------------------------------------------------------------
--7
SELECT
	tb_cliente.nome,
	tb_cliente.cnh,
	tb_veiculo.modelo,
	tb_veiculo.placa,
	tb_veiculo.disponibilidade,
	tb_aluguel.aluguel_id,
	tb_aluguel.data_inicio,
	tb_aluguel.data_fim
FROM
	tb_aluguel
INNER JOIN
	tb_cliente ON tb_cliente.cliente_id = tb_aluguel.cliente_id
INNER JOIN
	tb_veiculo ON tb_veiculo.veiculo_id = tb_aluguel.veiculo_id
------------------------------------------------------------------------
--8
SELECT
	tb_cliente.nome,
	tb_cliente.cnh,
	tb_veiculo.modelo,
	tb_veiculo.placa,
	tb_veiculo.disponibilidade,
	tb_aluguel.aluguel_id,
	tb_aluguel.data_inicio,
	tb_aluguel.data_fim
FROM
	tb_aluguel
INNER JOIN
	tb_cliente ON tb_cliente.cliente_id = tb_aluguel.cliente_id
INNER JOIN
	tb_veiculo ON tb_veiculo.veiculo_id = tb_aluguel.veiculo_id
WHERE
	tb_veiculo.disponibilidade = "disponivel";
    
--------------------------------------------------------------------------
--9
SELECT
	tb_cliente.nome,
	tb_cliente.cnh,
	tb_veiculo.modelo,
	tb_veiculo.placa,
	tb_veiculo.disponibilidade,
	tb_aluguel.aluguel_id,
	tb_aluguel.data_inicio,
	tb_aluguel.data_fim
FROM
	tb_aluguel
INNER JOIN
	tb_cliente ON tb_cliente.cliente_id = tb_aluguel.cliente_id
INNER JOIN
	tb_veiculo ON tb_veiculo.veiculo_id = tb_aluguel.veiculo_id
WHERE
	tb_veiculo.disponibilidade = "alugado";
    
-----------------------------------------------------------------
--10
UPDATE tb_cliente
SET telefone = "358756786"
WHERE cliente_id = 1;

UPDATE tb_cliente
SET telefone = "7384657486"
WHERE cliente_id = 2;

UPDATE tb_cliente
SET telefone = "7465865834"
WHERE cliente_id = 6;

UPDATE tb_cliente
SET telefone = "9458390685"
WHERE cliente_id = 8;

UPDATE tb_cliente
SET telefone = "485729487"
WHERE cliente_id = 5;
--------------------------------------------------------------------
--11
UPDATE tb_veiculo
SET ano = "2016"
WHERE veiculo_id = 3;

UPDATE tb_veiculo
SET ano = "2022"
WHERE veiculo_id = 4;

UPDATE tb_veiculo
SET ano = "2014"
WHERE veiculo_id = 1;

UPDATE tb_veiculo
SET ano = "2013"
WHERE veiculo_id = 8;

UPDATE tb_veiculo

SELECT * FROM tb_cliente WHERE telefone = "12345-6789";

SELECT * FROM tb_cliente WHERE cnh = "12345678901";

SELECT nome,cnh FROM tb_cliente ;


SELECT * FROM tb_veiculo WHERE ano = "2017";

SELECT * FROM tb_veiculo WHERE veiculo_id = "2";

SELECT * FROM tb_veiculo WHERE disponibilidade = "alugado";


SELECT
	tb_cliente.nome,
	tb_cliente.cnh,
	tb_veiculo.modelo,
	tb_veiculo.placa,
	tb_veiculo.disponibilidade,
	tb_aluguel.aluguel_id,
	tb_aluguel.data_inicio,
	tb_aluguel.data_fim
FROM
	tb_aluguel
INNER JOIN
	tb_cliente ON tb_cliente.cliente_id = tb_aluguel.cliente_id
INNER JOIN
	tb_veiculo ON tb_veiculo.veiculo_id = tb_aluguel.veiculo_id


SELECT
	tb_cliente.nome,
	tb_cliente.cnh,
	tb_veiculo.modelo,
	tb_veiculo.placa,
	tb_veiculo.disponibilidade,
	tb_aluguel.aluguel_id,
	tb_aluguel.data_inicio,
	tb_aluguel.data_fim
FROM
	tb_aluguel
INNER JOIN
	tb_cliente ON tb_cliente.cliente_id = tb_aluguel.cliente_id
INNER JOIN
	tb_veiculo ON tb_veiculo.veiculo_id = tb_aluguel.veiculo_id
WHERE
	tb_veiculo.disponibilidade = "disponivel";
    

SELECT
	tb_cliente.nome,
	tb_cliente.cnh,
	tb_veiculo.modelo,
	tb_veiculo.placa,
	tb_veiculo.disponibilidade,
	tb_aluguel.aluguel_id,
	tb_aluguel.data_inicio,
	tb_aluguel.data_fim
FROM
	tb_aluguel
INNER JOIN
	tb_cliente ON tb_cliente.cliente_id = tb_aluguel.cliente_id
INNER JOIN
	tb_veiculo ON tb_veiculo.veiculo_id = tb_aluguel.veiculo_id
WHERE
	tb_veiculo.disponibilidade = "alugado";
    

UPDATE tb_cliente
SET telefone = "358756786"
WHERE cliente_id = 1;

UPDATE tb_cliente
SET telefone = "7384657486"
WHERE cliente_id = 2;

UPDATE tb_cliente
SET telefone = "7465865834"
WHERE cliente_id = 6;

UPDATE tb_cliente
SET telefone = "9458390685"
WHERE cliente_id = 8;

UPDATE tb_cliente
SET telefone = "485729487"
WHERE cliente_id = 5;


UPDATE tb_veiculo
SET ano = "2016"
WHERE veiculo_id = 3;

UPDATE tb_veiculo
SET ano = "2022"
WHERE veiculo_id = 4;

UPDATE tb_veiculo
SET ano = "2014"
WHERE veiculo_id = 1;

UPDATE tb_veiculo
SET ano = "2013"
WHERE veiculo_id = 8;

UPDATE tb_veiculo