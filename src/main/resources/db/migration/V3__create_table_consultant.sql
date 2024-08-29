
CREATE TABLE consultant (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    codigo_at VARCHAR(255) NOT NULL,
    descricao_at VARCHAR(255) NOT NULL,
    senioridade VARCHAR(50) NOT NULL,
    ausencia_ini DATE,
    ausencia_fin DATE,
    ausencia_tipo VARCHAR(50),
    FOREIGN KEY (codigo_at) REFERENCES costs(codigo_at)
);

CREATE TABLE consultant_especialidade (
    consultant_id UUID REFERENCES consultant(id) ON DELETE CASCADE,
    especialidade VARCHAR(255) NOT NULL
);


