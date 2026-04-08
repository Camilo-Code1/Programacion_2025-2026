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

-- 3. Platillos (Antes Restaurantes)
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
    id_platillo INT, -- Para simplificar, un pedido = un platillo
    id_estado INT,
    fecha_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_platillo) REFERENCES Platillos(id),
    FOREIGN KEY (id_estado) REFERENCES EstadosEntrega(id)
);

-- --- INSERCIÓN DE DATOS ---

INSERT INTO EstilosCocina (nombre) VALUES ('Italiana'), ('Mexicana'), ('Americana');

INSERT INTO EstadosEntrega (estado) VALUES ('Pendiente'), ('En Cocina'), ('En Reparto'), ('Entregado');

-- Insertamos algunos platillos
INSERT INTO Platillos (nombre, precio, id_estilo) VALUES 
('Pizza Margherita', 12.50, 1),
('Tacos al Pastor', 8.90, 2),
('Hamburguesa Doble Queso', 11.00, 3);

-- Insertamos pedidos de prueba
INSERT INTO Pedidos (cliente, id_platillo, id_estado) VALUES 
('Juan Pérez', 1, 2),  -- Pizza en Cocina
('María García', 2, 1), -- Tacos Pendiente
('Luis López', 3, 3);  -- Hamburguesa en Reparto

SELECT * FROM Pedidos;

SELECT * FROM Platillos;

