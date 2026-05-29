DROP DATABASE IF EXISTS tienda;
CREATE DATABASE IF NOT EXISTS tienda;
USE tienda;

-- 1. Tabla de Categorías
CREATE TABLE categorias (
    id_categoria int PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL
);

-- 2. Tabla de Proveedores
CREATE TABLE proveedores (
    id_proveedor int PRIMARY KEY AUTO_INCREMENT,
    nombre_empresa VARCHAR(50) NOT NULL,
    contacto VARCHAR(50) NOT NULL
);

-- 3. Tabla de Productos (con relaciones)
CREATE TABLE productos (
    id_producto int PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    precio DOUBLE NOT NULL,
    stock int NOT NULL,
    id_categoria int,
    id_proveedor int,
    FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria),
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor)
);

-- Inserts iniciales
INSERT INTO categorias (nombre) VALUES ('Electrónica'), ('Hogar');
INSERT INTO proveedores (nombre_empresa, contacto) VALUES ('TechDistro', 'contacto@tech.com'), ('HomeStyle', 'ventas@homestyle.es');

INSERT INTO productos (nombre, precio, stock, id_categoria, id_proveedor) 
VALUES ('Laptop Gaming', 1200.50, 10, 1, 1);
INSERT INTO productos (nombre, precio, stock, id_categoria, id_proveedor) 
VALUES ('Auriculares Bluetooth', 85.00, 50, 1, 1);
INSERT INTO productos (nombre, precio, stock, id_categoria, id_proveedor) 
VALUES ('Lámpara LED', 25.99, 100, 2, 2);