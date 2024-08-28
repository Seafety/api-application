CREATE TABLE costs (
    exercicio INT NOT NULL,
    periodo INT NOT NULL,
    codigo_at VARCHAR(255) PRIMARY KEY,
    categoria VARCHAR(255) NOT NULL,
    valor_at DECIMAL(15, 2) NOT NULL
);
