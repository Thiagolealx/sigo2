CREATE OR REPLACE FUNCTION row_updated() RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at := current_timestamp;
    RETURN NEW;
END
$$ LANGUAGE plpgsql;

CREATE TABLE example_model (
    id int GENERATED BY DEFAULT AS IDENTITY,
    name varchar(100) NOT NULL,
    description text,
    created_at timestamp NOT NULL DEFAULT current_timestamp,
    updated_at timestamp NOT NULL DEFAULT current_timestamp,

    PRIMARY KEY (id),
    CONSTRAINT example_model_key UNIQUE (name)
);

CREATE TRIGGER example_model_updated
    BEFORE UPDATE ON example_model
    FOR EACH ROW EXECUTE FUNCTION row_updated();

CREATE TABLE example_related_model (
    id int GENERATED BY DEFAULT AS IDENTITY,
    parent_id int NOT NULL REFERENCES example_model (id),
    name varchar(100) NOT NULL,
    description text,
    created_at timestamp NOT NULL DEFAULT current_timestamp,
    updated_at timestamp NOT NULL DEFAULT current_timestamp,

    PRIMARY KEY (id),
    CONSTRAINT example_related_model_key UNIQUE (parent_id, name)
);

CREATE TRIGGER example_related_model_updated
    BEFORE UPDATE ON example_related_model
    FOR EACH ROW EXECUTE FUNCTION row_updated();
