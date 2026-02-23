-- Create 'keycloak' user
CREATE USER "keycloak" WITH PASSWORD 'keycloak';
-- Create 'keycloak' schema
CREATE SCHEMA "keycloak";
-- Assign 'keycloak' schema ownership to 'keycloak' user
ALTER SCHEMA "keycloak" OWNER TO "keycloak";

-- Create 'demo' user
CREATE USER "demo" WITH PASSWORD 'demo';
-- Create 'demo' schema
CREATE SCHEMA "demo";
-- Assign 'demo' schema ownership to 'demo' user
ALTER SCHEMA "demo" OWNER TO "demo";
