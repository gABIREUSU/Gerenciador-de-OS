CREATE DATABASE DA123_Exerc_G07;
GO

USE DA123_Exerc_G07;
GO

CREATE LOGIN DA123_Exerc_G07 
WITH PASSWORD = '', CHECK_POLICY = OFF, CHECK_EXPIRATION = OFF;
GO

CREATE USER DA123_Exerc_G07 FOR LOGIN DA123_Exerc_G07;
GO

ALTER ROLE db_owner ADD MEMBER DA123_Exerc_G07;
GO

CREATE TABLE Empresas (
    Cod_Emp INT PRIMARY KEY,
    Nome VARCHAR(20) NOT NULL,
    CNPJ VARCHAR(18) UNIQUE NOT NULL,
    Endereco VARCHAR(90),
    Telefone VARCHAR(15)
);

CREATE TABLE Equipamento (
    Cod_Equip INT PRIMARY KEY,
    Nome_Equip VARCHAR(20) NOT NULL,
    Cod_Emp INT NOT NULL,
    FOREIGN KEY (Cod_Emp) REFERENCES Empresas(Cod_Emp)
);

CREATE TABLE OS (
    Cod_OS INT PRIMARY KEY,
    Cod_Equip INT NOT NULL,
    Data VARCHAR(20),
    Preco NUMERIC(10,2),
    FOREIGN KEY (Cod_Equip) REFERENCES Equipamento(Cod_Equip)
);

CREATE TABLE Item (
    Cod_Item INT PRIMARY KEY,
    Tipo CHAR(1),
    Descricao VARCHAR(40),
    Preco NUMERIC(10,2)
);

CREATE TABLE OSxItem (
    Cod_OS INT NOT NULL,
    Cod_Item INT NOT NULL,
    PRIMARY KEY (Cod_OS, Cod_Item),
    FOREIGN KEY (Cod_OS) REFERENCES OS(Cod_OS),
    FOREIGN KEY (Cod_Item) REFERENCES Item(Cod_Item)
);

INSERT INTO Item (Cod_Item, Tipo, Descricao, Preco) VALUES 
(1, 'I', 'Memória RAM 8GB DDR3 Notebook', 120.00),
(2, 'I', 'HD 1TB SATA 2.5"', 200.00),
(3, 'I', 'Teclado USB Padrão ABNT2', 75.50),
(4, 'S', 'Formatação de Sistema Operacional', 150.00),
(5, 'S', 'Instalação de Software Básico', 80.00),
(6, 'I', 'Fonte ATX 500W', 180.00),
(7, 'S', 'Limpeza interna e externa', 90.00),
(8, 'I', 'Mouse Óptico USB', 40.00),
(9, 'S', 'Troca de Memória RAM', 60.00),
(10, 'S', 'Configuração de Rede Wi-Fi', 100.00);
