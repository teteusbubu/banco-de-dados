-- Tabela para armazenar informações sobre flores
CREATE TABLE tb_flor (
    codigo_identificacao INT PRIMARY KEY,
    nome_cientifico VARCHAR(255) NOT NULL,
    nome_popular VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    quantidade_estoque INT NOT NULL,
    cores_disponiveis VARCHAR(255) NOT NULL
);

-- Tabela para armazenar informações sobre clientes
CREATE TABLE tb_cliente (
    cpf VARCHAR(14) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    endereco_entrega VARCHAR(255) NOT NULL
);

-- Tabela para armazenar informações sobre pedidos de compra
CREATE TABLE tb_pedido (
    numero_pedido INT PRIMARY KEY,
    data_realizacao DATE NOT NULL,
    valor_total DECIMAL(10, 2) NOT NULL,
    cpf_cliente VARCHAR(14) REFERENCES tb_cliente(cpf),
    data_entrega DATE NOT NULL,
    horario_entrega TIME NOT NULL
);

-- Tabela para armazenar informações sobre as flores em cada pedido
CREATE TABLE tb_pedidoFlor (
    numero_pedido INT,
    codigo_flor INT,
    quantidade INT NOT NULL,
    PRIMARY KEY (numero_pedido, codigo_flor),
    FOREIGN KEY (numero_pedido) REFERENCES tb_pedido(numero_pedido),
    FOREIGN KEY (codigo_flor) REFERENCES tb_flor(codigo_identificacao)
);


-- Inserir dados na tabela Flor
INSERT INTO tb_flor (codigo_identificacao, nome_cientifico, nome_popular, preco, quantidade_estoque, cores_disponiveis)
VALUES
    (1, 'Rosa spp.', 'Rosa', 10.99, 100, 'Vermelha, Branca, Amarela'),
    (2, 'Tulipa spp.', 'Tulipa', 8.50, 50, 'Vermelha, Rosa, Amarela'),
    (3, 'Orquídea spp.', 'Orquídea', 15.75, 75, 'Branca, Rosa, Roxa'),
    (4, 'Girassol spp.', 'Girassol', 12.99, 80, 'Amarelo, Marrom'),
    (5, 'Lírio spp.', 'Lírio', 14.50, 60, 'Branco, Rosa, Laranja'),
    (6, 'Margarida spp.', 'Margarida', 9.75, 120, 'Branca, Amarela'),
    (7, 'Cravo spp.', 'Cravo', 7.99, 90, 'Vermelho, Rosa, Branco'),
    (8, 'Lavanda spp.', 'Lavanda', 18.50, 40, 'Lilás, Roxo'),
    (9, 'Violeta spp.', 'Violeta', 6.25, 100, 'Azul, Roxa, Branca'),
    (10, 'Gérbera spp.', 'Gérbera', 11.25, 70, 'Vermelha, Rosa, Amarela');

-- Inserir dados na tabela Cliente
INSERT INTO tb_cliente (cpf, nome, telefone, endereco_entrega)
VALUES
    ('456.789.012-34', 'Catarina Bene', '(44) 87654-4321', 'Alameda das Violetas, 987'),
    ('567.890.123-45', 'Suellen Souza', '(55) 76543-2109', 'Praça das Tulipas, 654'),
    ('678.901.234-56', 'Evandro Miguel', '(66) 65432-1098', 'Avenida das Margaridas, 321'),
    ('789.012.345-67', 'Felipe Luz', '(77) 54321-0987', 'Rua dos Girassóis, 543'),
    ('890.123.456-78', 'Matheus Oliveira', '(88) 43210-9876', 'Travessa das Lavandas, 876'),
    ('901.234.567-89', 'Thainá Cortez', '(99) 32109-8765', 'Rua das Gérberas, 234'),
    ('012.345.678-90', 'Caze lindinha', '(10) 98765-4321', 'Avenida das Cravos, 678'),
    ('123.456.789-01', 'Aninha Fofinha', '(21) 87654-3210', 'Praça das Violetas, 543'),
    ('234.567.890-12', 'Beatriz Poki', '(32) 76543-1098', 'Rua das Rosas, 876'),
    ('345.678.901-23', 'Lucas Oliveira', '(43) 65432-0987', 'Alameda das Orquídeas, 210');


-- Inserir dados na tabela Pedido
INSERT INTO tb_pedido (numero_pedido, data_realizacao, valor_total, cpf_cliente, data_entrega, horario_entrega)
VALUES
    (4, '2023-12-12', 120.99, '456.789.012-34', '2023-12-20', '14:00:00'),
    (5, '2023-12-14', 90.50, '567.890.123-45', '2023-12-18', '16:30:00'),
    (6, '2023-12-16', 60.25, '678.901.234-56', '2023-12-22', '15:45:00'),
    (7, '2023-12-18', 45.99, '789.012.345-67', '2023-12-16', '12:00:00'),
    (8, '2023-12-20', 75.50, '890.123.456-78', '2023-12-25', '13:45:00'),
    (9, '2023-12-22', 30.75, '901.234.567-89', '2023-12-28', '17:00:00'),
    (10, '2023-12-24', 55.99, '012.345.678-90', '2023-12-30', '11:30:00'),
    (11, '2023-12-26', 80.50, '123.456.789-01', '2023-12-29', '14:15:00'),
    (12, '2023-12-28', 110.25, '234.567.890-12', '2023-12-27', '18:00:00'),
    (13, '2023-12-30', 95.99, '345.678.901-23', '2023-12-26', '16:45:00');

-- Inserir dados na tabela PedidoFlor
INSERT INTO tb_pedidoFlor (numero_pedido, codigo_flor, quantidade)
VALUES
    (4, 1, 8),
    (4, 3, 5),
    (5, 2, 10),
    (5, 4, 7),
    (6, 6, 12),
    (6, 8, 4),
    (7, 7, 8),
    (8, 9, 6),
    (9, 10, 9),
    (10, 5, 11);

-- Verificar os dados na tabela
SELECT * FROM tb_cliente;

SELECT * FROM tb_pedido;

SELECT * FROM tb_pedidoFlor;




