
CREATE TABLE ticket (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    projeto_id UUID REFERENCES project(id) ON DELETE CASCADE,
    chamado INT NOT NULL,
    dt_abertura_chamado DATE NOT NULL,
    modulo_chamado VARCHAR(255) NOT NULL,
    tipo_chamado VARCHAR(50) NOT NULL,
    status_chamado VARCHAR(50) NOT NULL,
    consultant_id UUID REFERENCES consultant(id) ON DELETE CASCADE,
    modulo_consultor VARCHAR(255) NOT NULL,
    exercicio INT NOT NULL,
    periodo INT NOT NULL,
    dia INT NOT NULL,
    horas INT NOT NULL,
    tipo_horas VARCHAR(50) NOT NULL,
    complexidade VARCHAR(50) NOT NULL
);


