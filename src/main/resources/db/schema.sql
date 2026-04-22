CREATE TABLE IF NOT EXISTS collectivity (
                                            id SERIAL PRIMARY KEY,
                                            id_number VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(100) UNIQUE NOT NULL,
    city VARCHAR(100),
    specialty VARCHAR(100),
    creation_date DATE DEFAULT CURRENT_DATE
    );