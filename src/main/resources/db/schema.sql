CREATE TABLE IF NOT EXISTS collectivity (
                                            id SERIAL PRIMARY KEY,
                                            location VARCHAR(255),
    federation_approval BOOLEAN DEFAULT FALSE
    );

CREATE TABLE IF NOT EXISTS member (
                                      id SERIAL PRIMARY KEY,
                                      first_name VARCHAR(100),
    last_name VARCHAR(100),
    birth_date DATE,
    email VARCHAR(150),
    collectivity_id INT REFERENCES collectivity(id)
    );