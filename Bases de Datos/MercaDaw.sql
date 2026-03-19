DROP DATABASE IF EXISTS MercaDaw;
CREATE DATABASE MercaDaw;
USE MercaDaw;

-- Tabla para los tipos de producto (Requisito 8)
CREATE TABLE Tipos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Tabla de Productos
CREATE TABLE Productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    referencia VARCHAR(50) NOT NULL UNIQUE, 
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    tipo_id INT,
    cantidad INT DEFAULT 0,
    precio DOUBLE NOT NULL,
    descuento INT DEFAULT 0,
    iva INT DEFAULT 21,
    aplicar_dto BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (tipo_id) REFERENCES Tipos(id)
);

-- Datos de prueba iniciales
INSERT INTO Tipos (nombre) VALUES ('Alimentación'), ('Electrónica'), ('Hogar');
INSERT INTO Tipos (nombre) VALUES 
('Fruta y Verdura'), 
('Lácteos'), 
('Limpieza'), 
('Panadería');

-- Insertando productos variados
INSERT INTO Productos (referencia, nombre, descripcion, tipo_id, cantidad, precio, descuento, iva, aplicar_dto) 
VALUES 
('REF-001', 'Manzana Fuji', 'Manzanas dulces de importación', 1, 150, 2.50, 0, 4, FALSE),
('REF-002', 'Leche Entera 1L', 'Pack de 6 briks de leche entera', 2, 40, 5.80, 10, 4, TRUE),
('REF-003', 'Detergente Líquido', 'Jabón para ropa delicada 2L', 3, 25, 12.95, 5, 21, FALSE),
('REF-004', 'Auriculares Bluetooth', 'Cancelación de ruido activa', 4, 10, 89.99, 15, 21, TRUE),
('REF-005', 'Barra de Pan', 'Pan artesano recién horneado', 5, 100, 0.60, 0, 4, FALSE),
('REF-006', 'Yogur Griego Natural', 'Pack de 4 unidades sin azúcar', 2, 60, 1.95, 0, 10, FALSE);