CREATE DATABASE "federation_agricole_db";

CREATE USER "federation_admin" WITH PASSWORD '123456';

GRANT ALL PRIVILEGES ON DATABASE federation_agricole_db TO federation_admin;

ALTER DATABASE federation_agricole_db OWNER TO federation_admin;