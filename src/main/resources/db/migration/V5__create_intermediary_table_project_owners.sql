CREATE TABLE project_owners (
    project_id UUID NOT NULL REFERENCES project(id) ON DELETE CASCADE,
    consultant_id UUID NOT NULL REFERENCES consultant(id) ON DELETE CASCADE,
    PRIMARY KEY (project_id, consultant_id)
);
