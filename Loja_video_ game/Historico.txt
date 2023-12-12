---Criação tabelas
---------------------------------------------------------------------------------------------------------

CREATE TABLE "tb_plataforma" (
	"cod_plataforma"	INTEGER,
	"fabricante"	TEXT,
	"nome"	TEXT,
	
	PRIMARY KEY("cod_plataforma" AUTOINCREMENT)
);
CREATE TABLE "tb_jogos" (
	"cod_jogo"	INTEGER,
	"titulo"	TEXT,
	"genero"	TEXT,
	"lancamento"	TEXT,
	"cod_plataforma" INTEGER,
	CONSTRAINT "cod_plataforma" FOREIGN KEY("cod_plataforma") REFERENCES "tb_plataforma"("cod_plataforma"),
	PRIMARY KEY("cod_plataforma" AUTOINCREMENT)
);

---------------------------------------------------------------------------------------------------------
---Dados da tabela

INSERT INTO tb_plataforma(nome, fabricante)
	VALUES
	("PlayStation 5", "Sony"),
	("Xbox Series X", "Microsoft"),
	("Nitendo Switch", "Nintendo"),
	("PlayStation 4", "Sony"),
	("Xbox One", "Microsoft"),
	("Will U", "Nintendo"),
	("PlayStation 3", "Sony"),
	("Xbox 360", "Microsoft"),
	("Nintendo wil", "Nintendo"),
	("PlayStation 2", "Sony");
    
INSERT INTO tb_jogos (titulo, genero, lancamento, cod_plataforma)
	VALUES
	("Demon's Souls", "RPG", "2020-11-12", 1),
	("Ratchet & Clank: Rift Apart", "Ação/Aventura", "2021-06-11", 1),
	("Halo Infinite", "FPS", "2021-12-08", 2),
	("Forza Horizon 5", "Corrida", "2021-11-09", 2),
	("The Legend of Zelda: Breath of the Wild", "Ação/Aventura", "2017-03-03", 3),
	("Animal Crossing: New Horizons", "Simulação", "2020-03-20", 3),
	("God of War", "Ação/Aventura", "2018-04-20", 4),
	("Horizon Zero Dawn", "RPG", "2017-02-28", 4),
	("Gears of War 4", "Tiro", "2016-10-11", 5),
	("Forza Motorsport 7", "Corrida", "2017-10-03", 5);
    
----------------------------------------------------------------------------------------------------    
    
        SELECT titulo FROM tb_jogos WHERE cod_plataforma = 3;
        
        SELECT * FROM tb_jogos WHERE genero = "RPG";
        
SELECT 
	tb_jogos.cod_jogo,
	tb_jogos.titulo,
	tb_jogos.genero,
	tb_jogos.lancamento,
	tb_plataforma.nome as console
FROM 
	tb_jogos
INNER JOIN 
	tb_plataforma ON tb_plataforma.cod_plataforma = tb_jogos.cod_plataforma;

------------------------------------------------------------------------------------------------------
---Alteração de dados
    
    UPDATE tb_jogos
SET lancamento = "2023-05-15"
WHERE cod_jogo = 1;

UPDATE tb_jogos
SET lancamento = "2019-08-12"
WHERE cod_jogo = 4;

UPDATE tb_jogos
SET lancamento = "2023-02-22"
WHERE cod_jogo = 7;

UPDATE tb_jogos
SET lancamento = "2018-10-18"
WHERE cod_jogo = 3;

------------------------------------------------------------------------------------------------------------
---Exclusão de jogos

DELETE FROM tb_jogos WHERE cod_jogo = 2;
DELETE FROM tb_jogos WHERE cod_jogo = 7;
DELETE FROM tb_jogos WHERE cod_jogo = 5;
DELETE FROM tb_jogos WHERE cod_jogo = 9;
