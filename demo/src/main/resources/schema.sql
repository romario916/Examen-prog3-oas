CREATE TYPE gender_enum AS ENUM ('M', 'F');
CREATE TYPE account_type_enum AS ENUM ('CASH', 'MOBILE_MONEY', 'BANK');

CREATE TABLE collectivities (
                                id VARCHAR(50) PRIMARY KEY,
                                unique_number INTEGER UNIQUE NOT NULL,
                                name VARCHAR(100) UNIQUE NOT NULL,
                                location VARCHAR(100) NOT NULL,
                                specialty VARCHAR(100) NOT NULL,
                                creation_date DATE DEFAULT CURRENT_DATE
);

CREATE TABLE members (
                         id VARCHAR(50) PRIMARY KEY,
                         last_name VARCHAR(100) NOT NULL,
                         first_name VARCHAR(100) NOT NULL,
                         birth_date DATE NOT NULL,
                         gender gender_enum NOT NULL,
                         address TEXT,
                         job VARCHAR(100),
                         phone VARCHAR(20),
                         email VARCHAR(100),
                         occupation VARCHAR(50),
                         collectivity_id VARCHAR(50) REFERENCES collectivities(id)
);

CREATE TABLE accounts (
                          id VARCHAR(50) PRIMARY KEY,
                          collectivity_id VARCHAR(50) REFERENCES collectivities(id),
                          type account_type_enum NOT NULL,
                          holder_name VARCHAR(100),
                          phone_number VARCHAR(20),
                          balance DECIMAL(15, 2) DEFAULT 0.0
);

CREATE TABLE membership_fees (
                                 id VARCHAR(50) PRIMARY KEY,
                                 label VARCHAR(100) NOT NULL,
                                 status VARCHAR(20) NOT NULL,
                                 frequency VARCHAR(20) NOT NULL,
                                 eligible_since DATE,
                                 amount DECIMAL(15, 2) NOT NULL,
                                 collectivity_id VARCHAR(50) REFERENCES collectivities(id)
);

CREATE TABLE member_payments (
                                 id VARCHAR(50) PRIMARY KEY,
                                 member_id VARCHAR(50) REFERENCES members(id),
                                 amount DECIMAL(15, 2) NOT NULL,
                                 payment_mode VARCHAR(50) NOT NULL,
                                 account_id VARCHAR(50) REFERENCES accounts(id),
                                 creation_date DATE DEFAULT CURRENT_DATE
);

CREATE TABLE collectivity_transactions (
                                           id VARCHAR(50) PRIMARY KEY,
                                           amount DECIMAL(15, 2) NOT NULL,
                                           creation_date DATE DEFAULT CURRENT_DATE,
                                           account_id VARCHAR(50) REFERENCES accounts(id),
                                           member_debited_id VARCHAR(50) REFERENCES members(id)
);

CREATE TABLE sponsorships (
                              id SERIAL PRIMARY KEY,
                              member_id VARCHAR(50) REFERENCES members(id),
                              sponsor_id VARCHAR(50) REFERENCES members(id)
);