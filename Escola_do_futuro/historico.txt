-- Tabela de Alunos
CREATE TABLE Alunos (
    aluno_id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    cpf TEXT,
    rg TEXT,
    data_nascimento TEXT,
    endereco TEXT
);

-- Tabela de Cursos
CREATE TABLE Cursos (
    curso_id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    carga_horaria INTEGER
);

-- Tabela de Professores
CREATE TABLE Professores (
    professor_id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    especialidade TEXT,
    contato TEXT
);

-- Tabela de Matrículas
CREATE TABLE Matriculas (
    matricula_id INTEGER PRIMARY KEY AUTOINCREMENT,
    aluno_id INTEGER,
    curso_id INTEGER,
    notas_n1 REAL,
    notas_n2 REAL,
    notas_n3 REAL,
    notas_n4 REAL,
    FOREIGN KEY (aluno_id) REFERENCES Alunos(aluno_id),
    FOREIGN KEY (curso_id) REFERENCES Cursos(curso_id)
);

-- Associação entre Professores e Cursos
CREATE TABLE MinistraCurso (
    professor_id INTEGER,
    curso_id INTEGER,
    PRIMARY KEY (professor_id, curso_id),
    FOREIGN KEY (professor_id) REFERENCES Professores(professor_id),
    FOREIGN KEY (curso_id) REFERENCES Cursos(curso_id)
);


--Inserindo informações nas tabelas

INSERT INTO tb_alunos (nome, cpf, rg, "data_nascimento", endereco)
VALUES
    ('João da Silva', '12345678901', '(123) 456-7890', '12/12/2006', 'Aflitos'),
    ('Maria Santos', '98765432109', '(987) 654-3210', '19/10/2008', 'Afogados.'),
    ('Pedro Alves', '56789012345', '(567) 890-1234', '22/09/2005', 'Água Fria'),
    ('Ana Pereira', '34567890123', '(345) 678-9012','05/02/2007', 'Alto José Bonifácio'),
    ('José Oliveira', '89012345678', '(890) 123-4567', '27/11/2006', 'Afogados'),
    ('Mariana Souza', '23456789012', '(234) 567-8901' ,'16/10/2008', 'Alto José Bonifácio'),
    ('Ricardo Fernandes', '67890123456', '(678) 901-2345', '22/07/2005', 'Aflitos'),
    ('Isabela Costa', '45678901234', '(456) 789-0123', '07/11/2007', 'Afogados'),
    ('Luiz Gomes', '78901234567', '(789) 012-3456', '12/08/2008', 'Aflitos'),
    ('Clara Santos', '12309876543', '(123) 098-7654', '01/10/2005', 'Alto José Bonifácio'),
    ('Fernando Lima', '21098765432', '(210) 987-6543', '04/07/2006', 'Aflitos'),
    ('Juliana Pereira', '43210987654', '(432) 109-8765', '26/12/2005', 'Alto José Bonifácio'),
    ('Antônio Rodrigues', '54321098765', '(543) 210-9876' , '18/05/2008', 'Afogados'),
    ('Beatriz Almeida', '87654321098', '(876) 543-2109' , '28/06/2007', 'Alto José Bonifácio'),
    ('Lucas Oliveira', '98765432109', '(987) 654-3210' , '06/12/2005', 'Aflitos');

INSERT INTO tb_cursos(nome, carga_horaria)
VALUES
    ('ingles', '75h'),
	('administracao', '60h'),
	('informatica', '40h');

INSERT INTO tb_professores (nome, especialidade, contato)
VALUES
    ('Prof. Carlos Silva', 'Informática', 'carlos.silva@example.com'),
    ('Prof. Ana Oliveira', 'Inglês', 'ana.oliveira@example.com'),
    ('Prof. Marcos Pereira', 'Administração', 'marcos.pereira@example.com'),
    ('Prof. Fernanda Santos', 'Informática', 'fernanda.santos@example.com'),
    ('Prof. Ricardo Lima', 'Inglês', 'ricardo.lima@example.com'),
    ('Prof. Juliana Rodrigues', 'Administração', 'juliana.rodrigues@example.com'),
    ('Prof. Felipe Almeida', 'Informática', 'felipe.almeida@example.com'),
    ('Prof. Vanessa Costa', 'Inglês', 'vanessa.costa@example.com'),
    ('Prof. Gustavo Gomes', 'Administração', 'gustavo.gomes@example.com'),
    ('Prof. Laura Santos', 'Informática', 'laura.santos@example.com');

INSERT INTO tb_matriculas (aluno_id, curso_id, notas_n1, notas_n2, notas_n3, notas_n4)
VALUES
    (1, 1, 8.5, 7.2, 9.0, 8.8),
    (2, 2, 9.0, 8.5, 7.5, 9.5),
    (3, 3, 7.8, 9.2, 8.0, 7.5),
    (4, 1, 8.0, 7.5, 8.8, 9.2),
    (5, 2, 9.5, 8.0, 7.2, 8.7),
    (6, 3, 7.2, 8.8, 9.5, 8.0),
    (7, 1, 8.8, 9.0, 7.5, 8.2),
    (8, 2, 7.5, 9.5, 8.2, 7.8),
    (9, 3, 9.2, 7.2, 8.5, 9.0),
    (10, 1, 8.0, 9.2, 8.7, 7.5),
    (11, 2, 8.5, 7.8, 9.0, 8.5),
    (12, 3, 7.5, 8.5, 8.0, 9.2),
    (13, 1, 9.0, 8.0, 7.8, 8.8),
    (14, 2, 8.2, 7.5, 9.2, 8.0),
    (15, 3, 8.7, 9.0, 7.2, 7.8);

INSERT INTO tb_ministraCurso (professor_id, curso_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 1),
    (5, 2),
    (6, 3),
    (7, 1),
    (8, 2),
    (9, 3);

--
SELECT * FROM tb_alunos WHERE endereco = 'Aflitos';

SELECT * FROM tb_alunos WHERE cpf = '21098765432';

SELECT nome, cpf FROM tb_alunos;


