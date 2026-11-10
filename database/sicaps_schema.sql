-- Esquema minimo para ejecutar el modulo CRUD de pacientes.
-- Ejecutar en MySQL Workbench antes de iniciar el programa.

CREATE DATABASE IF NOT EXISTS sicaps
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE sicaps;

CREATE TABLE IF NOT EXISTS pacientes (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(150) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);
