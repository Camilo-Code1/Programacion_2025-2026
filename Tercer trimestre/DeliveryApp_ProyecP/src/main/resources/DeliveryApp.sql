DROP DATABASE IF EXISTS DeliveryApp;
CREATE DATABASE DeliveryApp;
USE DeliveryApp;

-- 1. Estilos de Cocina
CREATE TABLE EstilosCocina (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- 2. Estados del Pedido
CREATE TABLE EstadosEntrega (
    id INT AUTO_INCREMENT PRIMARY KEY,
    estado VARCHAR(30) NOT NULL UNIQUE
);

-- 3. Platillos
CREATE TABLE Platillos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DOUBLE NOT NULL,
    id_estilo INT,
    FOREIGN KEY (id_estilo) REFERENCES EstilosCocina(id)
);

-- 4. Pedidos
CREATE TABLE Pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente VARCHAR(100) NOT NULL,
    id_platillo INT, 
    id_estado INT,
    fecha_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_platillo) REFERENCES Platillos(id),
    FOREIGN KEY (id_estado) REFERENCES EstadosEntrega(id)
);

-- --- INSERCIÓN DE DATOS ---

-- Añadimos 5 estilos en total
INSERT INTO EstilosCocina (nombre) VALUES 
('Italiana'), 
('Mexicana'), 
('Americana'), 
('Asiática'), 
('Mediterránea');

-- Estados estándar
INSERT INTO EstadosEntrega (estado) VALUES 
('Pendiente'), -- ID 1
('En Cocina'), -- ID 2
('En Reparto'), -- ID 3
('Entregado');  -- ID 4

-- Insertamos platillos variados
INSERT INTO Platillos (nombre, precio, id_estilo) VALUES 
('Pizza Margarita', 12.50, 1),
('Tacos al Pastor', 8.90, 2),
('Hamburguesa Doble Queso', 11.00, 3),
('Sushi Variado 12 pzs', 18.50, 4),
('Ramen de Tonkotsu', 13.20, 4),
('Paella de Marisco', 15.00, 5),
('Ensalada Griega', 9.50, 5);

-- --- PEDIDOS DE PRUEBA (2 por cada estado) ---

INSERT INTO Pedidos (cliente, id_platillo, id_estado) VALUES 
-- Pendientes (ID 1)
('María García', 2, 1),
('Carlos Ruiz', 4, 1),

-- En Cocina (ID 2)
('Juan Pérez', 1, 2),
('Ana Belén', 5, 2),

-- En Reparto (ID 3)
('Luis López', 3, 3),
('Pedro Mármol', 6, 3),

-- Entregados (ID 4)
('Sofía Soler', 7, 4),
('Miguel Ángel', 1, 4);

SELECT * FROM Pedidos;

SELECT * FROM Platillos;

