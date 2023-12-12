-- Tabela de Passageiros
CREATE TABLE tb_passageiros (
    CPF VARCHAR(11) PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    DataNascimento DATE NOT NULL,
    Telefone1 VARCHAR(20),
    Telefone2 VARCHAR(20),
    Rua VARCHAR(100),
    Numero INT,
    CEP VARCHAR(10),
    Complemento VARCHAR(50),
    Bairro VARCHAR(50),
    Cidade VARCHAR(50),
    Estado VARCHAR(2)
);

-- Tabela de Rotas
CREATE TABLE tb_rotas (
    RotaID INT PRIMARY KEY,
    CodigoRota VARCHAR(10) UNIQUE,
    Origem VARCHAR(50) NOT NULL,
    Destino VARCHAR(50) NOT NULL
);

-- Tabela de Aviões
CREATE TABLE tb_avioes (
    AviaoID INT PRIMARY KEY,
    NumeroAviao VARCHAR(20) UNIQUE
);

-- Tabela de Voos
CREATE TABLE tb_voos (
    VooID INT PRIMARY KEY,
    NumeroVoo VARCHAR(10) UNIQUE,
    RotaID INT,
    AviaoID INT,
    HorarioPartida DATETIME NOT NULL,
    HorarioChegada DATETIME NOT NULL,
    FOREIGN KEY (RotaID) REFERENCES tb_rotas(RotaID),
    FOREIGN KEY (AviaoID) REFERENCES tb_avioes(AviaoID)
);

-- Tabela de Reservas
CREATE TABLE tb_reservas (
    ReservaID INT PRIMARY KEY,
    CPFPassageiro VARCHAR(11),
    VooID INT,
    NumeroAssento INT,
    FOREIGN KEY (CPFPassageiro) REFERENCES tb_passageiros(CPF),
    FOREIGN KEY (VooID) REFERENCES tb_voos(VooID)
);

------------------------------------------------------------------------------------------------------------------

-- Inserção de dados na tabela tb_passageiros
INSERT INTO tb_passageiros (CPF, Nome, DataNascimento, Telefone1, Telefone2, Rua, Numero, CEP, Complemento, Bairro, Cidade, Estado)
VALUES
('12345678901', 'João Silva', '1990-01-15', '111111111', '222222222', 'Rua A', 123, '12345-678', 'Apto 101', 'Centro', 'Cidade A', 'SP'),
('98765432109', 'Maria Oliveira', '1985-05-20', '333333333', '444444444', 'Rua B', 456, '54321-876', 'Casa 202', 'Bairro B', 'Cidade B', 'RJ'),
('11122233344', 'Ana Souza', '1988-03-25', '555555555', '666666666', 'Rua C', 789, '98765-432', 'Sala 303', 'Bairro C', 'Cidade C', 'MG'),
('22233344455', 'Carlos Lima', '1977-11-10', '777777777', '888888888', 'Rua D', 101, '11223-445', 'Casa 404', 'Bairro D', 'Cidade D', 'RS'),
('55566677788', 'Fernanda Santos', '1995-08-12', '999999999', '000000000', 'Rua E', 234, '87654-321', 'Apto 505', 'Bairro E', 'Cidade E', 'SC'),
('44455566677', 'Rodrigo Pereira', '1982-04-30', '121212121', '343434343', 'Rua F', 567, '23456-789', 'Casa 606', 'Bairro F', 'Cidade F', 'BA'),
('88899900011', 'Amanda Silva', '1993-12-08', '565656565', '787878787', 'Rua G', 890, '34567-890', 'Sala 707', 'Bairro G', 'Cidade G', 'GO'),
('99900011122', 'Gustavo Oliveira', '1989-06-15', '232323232', '454545454', 'Rua H', 112, '45678-901', 'Casa 808', 'Bairro H', 'Cidade H', 'PR'),
('33344455566', 'Patricia Lima', '1979-02-18', '676767676', '898989898', 'Rua I', 345, '56789-012', 'Apto 909', 'Bairro I', 'Cidade I', 'AM'),
('00011122233', 'Lucas Santos', '1998-10-05', '454545454', '676767676', 'Rua J', 678, '67890-123', 'Casa 1010', 'Bairro J', 'Cidade J', 'PA');


-- Inserção de dados na tabela tb_rotas
INSERT INTO tb_rotas (RotaID, CodigoRota, Origem, Destino)
VALUES
(1, 'ROTA001', 'Cidade A', 'Cidade B'),
(2, 'ROTA002', 'Cidade B', 'Cidade C'),
(3, 'ROTA003', 'Cidade C', 'Cidade D'),
(4, 'ROTA004', 'Cidade D', 'Cidade A'),
(5, 'ROTA005', 'Cidade E', 'Cidade F'),
(6, 'ROTA006', 'Cidade F', 'Cidade G'),
(7, 'ROTA007', 'Cidade G', 'Cidade H'),
(8, 'ROTA008', 'Cidade H', 'Cidade I'),
(9, 'ROTA009', 'Cidade I', 'Cidade J'),
(10, 'ROTA010', 'Cidade J', 'Cidade A');

-- Inserção de dados na tabela tb_avioes
INSERT INTO tb_avioes (AviaoID, NumeroAviao)
VALUES
(1, 'ABC123'),
(2, 'XYZ789'),
(3, 'JKL567'),
(4, 'MNO890'),
(5, 'PQR456'),
(6, 'STU012'),
(7, 'VWX345'),
(8, 'YZA678'),
(9, 'BCD901'),
(10, 'EFG234');

-- Inserção de dados na tabela tb_voos
INSERT INTO tb_voos (VooID, NumeroVoo, RotaID, AviaoID, HorarioPartida, HorarioChegada)
VALUES
(1, 'V001', 1, 1, '2023-01-01 10:00:00', '2023-01-01 12:00:00'),
(2, 'V002', 2, 2, '2023-01-02 14:00:00', '2023-01-02 16:00:00'),
(3, 'V003', 3, 3, '2023-01-03 12:00:00', '2023-01-03 14:00:00'),
(4, 'V004', 4, 4, '2023-01-04 16:00:00', '2023-01-04 18:00:00'),
(5, 'V005', 5, 5, '2023-01-05 08:00:00', '2023-01-05 10:00:00'),
(6, 'V006', 6, 6, '2023-01-06 18:00:00', '2023-01-06 20:00:00'),
(7, 'V007', 7, 7, '2023-01-07 09:00:00', '2023-01-07 11:00:00'),
(8, 'V008', 8, 8, '2023-01-08 13:00:00', '2023-01-08 15:00:00'),
(9, 'V009', 9, 9, '2023-01-09 17:00:00', '2023-01-09 19:00:00'),
(10, 'V010', 10, 10, '2023-01-10 11:00:00', '2023-01-10 13:00:00');


-- Inserção de dados na tabela tb_reservas
INSERT INTO tb_reservas (ReservaID, CPFPassageiro, VooID, NumeroAssento)
VALUES
(1, '12345678901', 1, 5),
(2, '98765432109', 2, 8),
(3, '11122233344', 3, 10),
(4, '22233344455', 4, 15),
(5, '55566677788', 5, 20),
(6, '44455566677', 6, 25),
(7, '88899900011', 7, 30),
(8, '99900011122', 8, 35),
(9, '33344455566', 9, 40),
(10, '00011122233', 10, 45);

------------------------------------------------------------------------------------------------------------------

SELECT * FROM tb_passageiros;
SELECT * FROM tb_reservas;
SELECT * FROM tb_rotas;








