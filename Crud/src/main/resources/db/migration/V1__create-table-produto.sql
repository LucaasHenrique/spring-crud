CREATE TABLE produtos (
    id VARCHAR(255) PRIMARY KEY UNIQUE NOT NULL,
    nome VARCHAR(255) NOT NULL,
    preco_em_centavos INT NOT NULL
);