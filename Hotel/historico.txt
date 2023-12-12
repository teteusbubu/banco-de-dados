--Criação de tabelas

CREATE TABLE tb_hospede (
    hospede_id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    documento VARCHAR(20),
    telefone VARCHAR(15)
);

CREATE TABLE tb_quarto (
    quarto_id INTEGER PRIMARY KEY AUTOINCREMENT,
    tipo VARCHAR(50) NOT NULL,
    preco_diaria DECIMAL(10, 2) NOT NULL,
    status VARCHAR(20) NOT NULL
);

CREATE TABLE tb_reserva (
    reserva_id INTEGER PRIMARY KEY AUTOINCREMENT,
    hospede_id INTEGER,
    quarto_id INTEGER,
    data_entrada DATE NOT NULL,
    data_saida DATE NOT NULL,
    FOREIGN KEY (hospede_id) REFERENCES tb_hospede(hospede_id),
    FOREIGN KEY (quarto_id) REFERENCES tb_quarto(quarto_id)
);

--Inserir dados a tabela

INSERT INTO tb_hospede (nome, documento, telefone) VALUES
    ('Maria Souza', '789012345', '654321098'),
    ('José Lima', '234567890', '876543210'),
    ('Amanda Costa', '901234567', '321098765'),
    ('Eduardo Rocha', '345678901', '210987654'),
    ('Gabriela Mendes', '678901234', '543210987'),
    ('Rafael Oliveira', '123456789', '876543210'),
    ('Camila Pereira', '456789012', '109876543'),
    ('Lucas Santos', '789012345', '432109876'),
    ('Isabela Lima', '234567890', '987654321'),
    ('Vinícius Rocha', '901234567', '876543210');

INSERT INTO tb_quarto (tipo, preco_diaria, status) VALUES
    ('Simples', 100.00, 'Disponível'),
    ('Duplo', 150.00, 'Disponível'),
    ('Suíte', 200.00, 'Ocupado'),
    ('Simples', 110.00, 'Manutenção'),
    ('Duplo', 160.00, 'Disponível'),
    ('Suíte', 220.00, 'Ocupado'),
    ('Simples', 120.00, 'Disponível'),
    ('Duplo', 170.00, 'Manutenção'),
    ('Suíte', 230.00, 'Disponível'),
    ('Simples', 130.00, 'Ocupado');

INSERT INTO tb_reserva (hospede_id, quarto_id, data_entrada, data_saida) VALUES
    (1, 1, '2023-12-10', '2023-12-15'),
    (2, 2, '2023-12-12', '2023-12-18'),
    (3, 3, '2023-12-15', '2023-12-20'),
    (4, 4, '2023-12-18', '2023-12-22'),
    (5, 5, '2023-12-20', '2023-12-25'),
    (6, 6, '2023-12-22', '2023-12-28'),
    (7, 7, '2023-12-25', '2023-12-30'),
    (8, 8, '2023-12-28', '2023-12-31'),
    (9, 9, '2023-12-30', '2024-01-05'),
    (10, 10, '2024-01-02', '2024-01-08');

--Recuperar informações da tabela Hospede

SELECT * FROM tb_hospede WHERE documento = '123456789';

SELECT nome, documento, telefone FROM tb_hospede WHERE hospede_id = 1;

-- Recuperar informações da tabela Quarto

SELECT * FROM tb_quarto WHERE tipo = 'Simples';

SELECT * FROM tb_quarto WHERE preco_diaria > 120.00;

SELECT status, COUNT(*) AS quantidade FROM tb_quarto GROUP BY status;

SELECT COUNT(*) AS quantidade FROM tb_quarto WHERE status = 'Disponível';

--

SELECT
    tb_reserva.reserva_id,
    tb_reserva.data_entrada,
    tb_reserva.data_saida,
    tb_hospede.nome,
    tb_hospede.documento,
    tb_quarto.tipo,
    tb_quarto.preco_diaria,
    tb_quarto.status
FROM
    tb_reserva tb_reserva
INNER JOIN
    tb_hospede tb_hospede ON tb_reserva.hospede_id = tb_hospede.hospede_id
INNER JOIN
    tb_quarto tb_quarto ON tb_reserva.quarto_id = tb_quarto.quarto_id;

--

SELECT
    tb_reserva.reserva_id,
    tb_reserva.data_entrada,
    tb_reserva.data_saida,
    tb_hospede.nome,
    tb_hospede.documento,
    tb_quarto.tipo,
    tb_quarto.preco_diaria,
    tb_quarto.status
FROM
    tb_reserva tb_reserva
INNER JOIN
    tb_hospede tb_hospede ON tb_reserva.hospede_id = tb_hospede.hospede_id
INNER JOIN
    tb_quarto tb_quarto ON tb_reserva.quarto_id = tb_quarto.quarto_id
WHERE
    tb_quarto.status = 'Ocupado';


----------------------------------------------------------------------------------------------------------------------------------

-- Alteração no nome e telefone do Hospede com hospede_id = 1
UPDATE tb_hospede SET nome = 'Novo Nome', telefone = '987654321' WHERE hospede_id = 1;

-- Alteração no documento do Hospede com hospede_id = 2
UPDATE tb_hospede SET documento = '987654321' WHERE hospede_id = 2;

-- Alteração no telefone do Hospede com hospede_id = 3
UPDATE tb_hospede SET telefone = '999999999' WHERE hospede_id = 3;

-- Alteração no nome e documento do Hospede com hospede_id = 4
UPDATE tb_hospede SET nome = 'Outro Nome', documento = '111222333' WHERE hospede_id = 4;

-- Alteração no nome do Hospede com hospede_id = 5
UPDATE tb_hospede SET nome = 'Mais um Nome' WHERE hospede_id = 5;




-----------------------------------------------------------------------------------------------------------------------------------


-- Alteração no tipo e preço_diaria do Quarto com quarto_id = 1
UPDATE tb_quarto SET tipo = 'Luxo', preco_diaria = 250.00 WHERE quarto_id = 1;

-- Alteração no tipo do Quarto com quarto_id = 2
UPDATE tb_quarto SET tipo = 'Duplo Luxo' WHERE quarto_id = 2;

-- Alteração no status do Quarto com quarto_id = 3
UPDATE tb_quarto SET status = 'Manutenção' WHERE quarto_id = 3;

-- Alteração no tipo e status do Quarto com quarto_id = 4
UPDATE tb_quarto SET tipo = 'Simples', status = 'Disponível' WHERE quarto_id = 4;

-- Alteração no status do Quarto com quarto_id = 5
UPDATE tb_quarto SET status = 'Ocupado' WHERE quarto_id = 5;

------------------------------------------------------------------------------------------------------------------------------

-- Exclusão da reserva com reserva_id = 1
DELETE FROM tb_reserva WHERE reserva_id = 1;

-- Exclusão da reserva com reserva_id = 2
DELETE FROM tb_reserva WHERE reserva_id = 2;

-- Exclusão da reserva com reserva_id = 3
DELETE FROM tb_reserva WHERE reserva_id = 3;

-- Exclusão da reserva com reserva_id = 4
DELETE FROM tb_reserva WHERE reserva_id = 4;

-- Exclusão da reserva com reserva_id = 5
DELETE FROM tb_reserva WHERE reserva_id = 5;





