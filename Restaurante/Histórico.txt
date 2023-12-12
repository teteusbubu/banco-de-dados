// Criação das tabelas
CREATE TABLE "tb_produtos" (
	"produto_id"	INTEGER,
	"nome"	TEXT NOT NULL,
	"tipo"	TEXT NOT NULL,
	"preco"	REAL NOT NULL,
	"descricao"	TEXT NOT NULL,
	PRIMARY KEY("produto_id" AUTOINCREMENT)
);

CREATE TABLE "tb_mesas" (

	"mesa_id" INTEGER,
	"numero" TEXT NOT NULL,
	"capacidade" TEXT NOT NULL,
	PRIMARY KEY ("mesa_id" AUTOINCREMENT)
	);
	
CREATE TABLE "tb_pedidos" (
	"pedido_id"	INTEGER,
	"mesa_id"	INTEGER,
	"produto_id" TEXT NOT NULL,
	"quantidade" TEXT NOT NULL,
	"total"	REAL NOT NULL,
	FOREIGN KEY("produto_id") REFERENCES "tb_produtos"("produto_id"),
	FOREIGN KEY("mesa_id") REFERENCES "tb_mesas"("mesa_id"),
	PRIMARY KEY("pedido_id" AUTOINCREMENT)
);


// Inserção de valores
INSERT INTO "tb_produtos" (nome, tipo, preco, descricao)
VALUES

	('suco laranja', 'bebida', '18,00', 'natural, 500ml'),
	('misto quente', 'lanche', '10,00', 'misto quente com presunto e queijo e outros aperitivos opcionais'),
	('sorvete creme', 'sobremesa', '15,00', 'sabor creme, tamanho medio'),
	('suco manga', 'bebida', '18,00', 'natural, 500ml'),
	('sorvete chocolate', 'sobremesa', '15,00', 'sabor chocolate, tamanho medio'),
	('sorvete morango', 'sobremesa', '15,00', ' sabor morango, tamanho medio'),
	('misto quente', 'lanche', '10,00', 'misto quente com presunto e queijo e outros aperitivos opcionais'),
	('refrigerante', 'bebida', '12,00', 'lata de coca, 350ml');
	
INSERT INTO "tb_mesas" (numero, capacidade)
VALUES

	('1', '2'),
	('2', '6'),
	('3', '7'),
	('4', '4'),
	('5', '5'),
	('6', '9'),
	('7', '2'),
	('8', '4');
    
INSERT INTO "tb_pedidos" (mesa_id, produto_id, quantidade, total)
VALUES

	('2', '3', '2', '40,00'),
	('2', '4', '3', '90,00'),
	('3', '2', '2', '15,00'),
	('4', '5', '4', '65,00'),
	('3', '1', '1', '33,00'),
	('2', '3', '2', '30,00'),
	('4', '7', '4', '20,00'),
	('2', '6', '3', '30,00'),
	('3', '1', '3', '30,00'),
	('2', '4', '2', '45,00');
    
// Consulta 
    
    5)

SELECT * FROM tb_produtos WHERE tipo = "bebida";

SELECT * FROM tb_mesas WHERE numero = "1";

SELECT nome, tipo, preco FROM tb_produtos;

    6)

SELECT * FROM tb_mesas WHERE numero = "1";

SELECT * FROM tb_mesas WHERE capacidade > "6";

    7)

SELECT
	tb_produtos.nome,
	tb_produtos.tipo,
	tb_produtos.preco,
	tb_mesas.numero,
	tb_mesas.capacidade,
	tb_pedidos.pedido_id,
	tb_pedidos.quantidade,
	tb_pedidos.total
FROM
	tb_pedidos
INNER JOIN
	tb_produtos ON tb_pedidos.produto_id = tb_produtos.produto_id
INNER JOIN
	tb_mesas ON tb_pedidos.mesa_id = tb_mesas.mesa_id;
    
    8)

SELECT
	tb_produtos.nome,
	tb_produtos.tipo,
	tb_produtos.preco,
	tb_mesas.numero,
	tb_mesas.capacidade,
	tb_pedidos.pedido_id,
	tb_pedidos.quantidade,
	tb_pedidos.total
FROM
	tb_pedidos
INNER JOIN
	tb_produtos ON tb_pedidos.produto_id = tb_produtos.produto_id
INNER JOIN
	tb_mesas ON tb_pedidos.mesa_id = tb_mesas.mesa_id
WHERE
	tb_pedidos.total = "10,00";
    
    9)

SELECT
	tb_produtos.nome,
	tb_produtos.tipo,
	tb_produtos.preco,
	tb_mesas.numero,
	tb_mesas.capacidade,
	tb_pedidos.pedido_id,
	tb_pedidos.quantidade,
	tb_pedidos.total
FROM
	tb_pedidos
INNER JOIN
	tb_produtos ON tb_pedidos.produto_id = tb_produtos.produto_id
INNER JOIN
	tb_mesas ON tb_pedidos.mesa_id = tb_mesas.mesa_id
WHERE
	tb_pedidos.total > "20,00";
    
    10)

UPDATE tb_produtos
SET nome = "suco natural"
WHERE produto_id = 1;

UPDATE tb_produtos
SET descricao = "suco natural"
WHERE produto_id = 3;

UPDATE tb_produtos
SET descricao = "misto"
WHERE produto_id = 7;

UPDATE tb_produtos
SET descricao = "misto"
WHERE produto_id = 2;

UPDATE tb_produtos
SET descricao = "coca-cola"
WHERE produto_id = 8;

11)

UPDATE tb_mesas
SET numero = "m4"
WHERE mesa_id = 4;

UPDATE tb_mesas
SET numero = "m2"
WHERE mesa_id = 2;

UPDATE tb_mesas
SET numero = "m5"
WHERE mesa_id = 5;

UPDATE tb_mesas
SET numero = "m8"
WHERE mesa_id = 8;

UPDATE tb_mesas
SET numero = "m6"
WHERE mesa_id = 6;

12)

DELETE FROM tb_pedidos WHERE pedido_id = 1;
DELETE FROM tb_pedidos WHERE pedido_id = 2;
DELETE FROM tb_pedidos WHERE pedido_id = 3;
DELETE FROM tb_pedidos WHERE pedido_id = 4;
DELETE FROM tb_pedidos WHERE pedido_id = 5;