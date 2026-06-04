DROP DATABASE IF EXISTS tienda;
CREATE DATABASE IF NOT EXISTS tienda;
USE tienda;

-- ==========================================
-- 1. CREACIÓN DE TABLAS
-- ==========================================

-- Tabla de Categorías
CREATE TABLE categorias (
    id_categoria int PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL
);

-- Tabla de Proveedores
CREATE TABLE proveedores (
    id_proveedor int PRIMARY KEY AUTO_INCREMENT,
    nombre_empresa VARCHAR(50) NOT NULL,
    contacto VARCHAR(50) NOT NULL
);

-- Tabla de Productos (Depende de categorias y proveedores)
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

-- Tabla de Gastos (Depende de proveedores)
CREATE TABLE gastos (
    id_gasto int PRIMARY KEY AUTO_INCREMENT, -- Cambiado a 'int' para estandarizar con los demás
    concepto VARCHAR(150) NOT NULL,            
    monto REAL NOT NULL,
    fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,         
    id_proveedor int,                                          
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor)
);

-- ==========================================
-- 2. INSERTS (En orden jerárquico lógico)
-- ==========================================

-- Primero: Tablas maestras/independientes
INSERT INTO categorias (nombre) VALUES 
('Electrónica'), 
('Hogar');

INSERT INTO proveedores (nombre_empresa, contacto) VALUES 
('TechDistro', 'contacto@tech.com'), 
('HomeStyle', 'ventas@homestyle.es');

-- Segundo: Tablas dependientes (Ya existen la categoría 1 y 2, y el proveedor 1 y 2)
INSERT INTO productos (nombre, precio, stock, id_categoria, id_proveedor) VALUES 
('Laptop Gaming', 1200.50, 10, 1, 1),
('Auriculares Bluetooth', 85.00, 50, 1, 1),
('Lámpara LED', 25.99, 100, 2, 2);

INSERT INTO gastos (concepto, monto, fecha, id_proveedor) VALUES 
('Pago de alquiler del local', 500.00, '2026-05-01', 1),
('Recibo de luz de la tienda', 75.30, '2026-05-10', 2),
('Compra de lote de Auriculares Bluetooth', 425.00, '2026-05-15', 1); -- Ahora el Proveedor 1 sí existe

-- ==========================================
-- 3. CONSULTAS DE PRUEBA
-- ==========================================
SELECT * FROM productos;
SELECT * FROM gastos;