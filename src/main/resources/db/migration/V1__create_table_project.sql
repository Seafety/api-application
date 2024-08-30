CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE project (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    projeto VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    tipo_contrato VARCHAR(255) NOT NULL,
    baseline INT NOT NULL,
    valor_contrato DECIMAL(15, 2) NOT NULL,
    horas_gestao INT NOT NULL,
    baseline_consumido INT NOT NULL,
    inicio_contrato DATE NOT NULL,
    fim_contrato DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    ativo BOOLEAN NOT NULL,

    -- Campos de PiramideVendas
    expert_piramide DECIMAL(15, 2) NOT NULL,
    senior_piramide DECIMAL(15, 2) NOT NULL,
    pleno_piramide DECIMAL(15, 2) NOT NULL,
    junior_piramide DECIMAL(15, 2) NOT NULL,
    estagiario_piramide DECIMAL(15, 2) NOT NULL,
    gestao_piramide DECIMAL(15, 2) NOT NULL,
    -- Campos de CustoVenda
    expert_custo DECIMAL(15, 2) NOT NULL,
    senior_custo DECIMAL(15, 2) NOT NULL,
    pleno_custo DECIMAL(15, 2) NOT NULL,
    junior_custo DECIMAL(15, 2) NOT NULL,
    estagiario_custo DECIMAL(15, 2) NOT NULL,
    gestao_custo DECIMAL(15, 2) NOT NULL
);


CREATE TABLE project_modulo (
    project_id UUID REFERENCES project(id) ON DELETE CASCADE,
    modulo VARCHAR(255) NOT NULL
);


CREATE TABLE project_tipo_demanda (
    project_id UUID REFERENCES project(id) ON DELETE CASCADE,
    tipo_demanda VARCHAR(255) NOT NULL
);
