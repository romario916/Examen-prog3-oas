


CREATE TYPE gender_enum AS ENUM ('MASCULIN', 'FEMININ');
CREATE TYPE account_type_enum AS ENUM ('CAISSE', 'BANQUE', 'MOBILE_MONEY');


CREATE TABLE collectivities (
    id SERIAL PRIMARY KEY,
    collectivity_number VARCHAR(20) UNIQUE NOT NULL,
    name VARCHAR(100) UNIQUE NOT NULL,
    city VARCHAR(100) NOT NULL,
    specialty VARCHAR(100) NOT NULL,
    creation_date DATE DEFAULT CURRENT_DATE,
    is_authorized BOOLEAN DEFAULT FALSE 
);


CREATE TABLE members (
    id SERIAL PRIMARY KEY,
    last_name VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL,
    gender gender_enum NOT NULL,
    job VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    admission_date DATE DEFAULT CURRENT_DATE,
    status VARCHAR(20) DEFAULT 'JUNIOR', 
    collectivity_id INTEGER REFERENCES collectivities(id)
);


CREATE TABLE accounts (
    id SERIAL PRIMARY KEY,
    collectivity_id INTEGER REFERENCES collectivities(id),
    type account_type_enum NOT NULL,
    bank_name VARCHAR(50), 
    rib CHAR(23) CHECK (rib ~ '^[0-9]{23}$'), 
    mobile_service VARCHAR(50), 
    balance DECIMAL(15, 2) DEFAULT 0.0
);


CREATE TABLE sponsorships (
    id SERIAL PRIMARY KEY,
    candidate_id INTEGER REFERENCES members(id),
    sponsor_id INTEGER REFERENCES members(id),
    relation_type VARCHAR(50), 
    is_local_sponsor BOOLEAN NOT NULL 
);