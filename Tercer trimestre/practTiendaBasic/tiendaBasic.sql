DROP DATABASE IF EXISTS hotel_practica;
CREATE DATABASE IF NOT EXISTS hotel_practica;
USE hotel_practica;

-- ==========================================
-- 1. CREACIÓN DE TABLAS
-- ==========================================

-- Tabla de Habitaciones
CREATE TABLE habitaciones (
    id_habitacion int PRIMARY KEY AUTO_INCREMENT,
    numero_habitacion VARCHAR(10) NOT NULL UNIQUE,
    tipo VARCHAR(50) NOT NULL, -- 'Individual', 'Doble', 'Suite'
    precio_noche DOUBLE NOT NULL,
    estado VARCHAR(20) DEFAULT 'Disponible' -- 'Disponible', 'Ocupada', 'Mantenimiento'
);

-- Tabla de Huéspedes
CREATE TABLE huespedes (
    id_huesped int PRIMARY KEY AUTO_INCREMENT,
    nombre_completo VARCHAR(100) NOT NULL,
    documento_identidad VARCHAR(20) NOT NULL UNIQUE,
    telefono VARCHAR(20)
);

-- Tabla de Reservas (Fechas manuales seleccionadas por el usuario)
CREATE TABLE reservas (
    id_reserve int PRIMARY KEY AUTO_INCREMENT,
    id_huesped int NOT NULL,
    id_habitacion int NOT NULL,
    fecha_entrada DATE NOT NULL, -- Selección desde DatePicker (Check-in)
    fecha_salida DATE NOT NULL,  -- Selección desde DatePicker (Check-out)
    monto_total DOUBLE NOT NULL DEFAULT 0.0,
    estado_reserva VARCHAR(20) DEFAULT 'Pendiente', -- 'Pendiente', 'Confirmada', 'Cancelada'
    FOREIGN KEY (id_huesped) REFERENCES huespedes(id_huesped),
    FOREIGN KEY (id_habitacion) REFERENCES habitaciones(id_habitacion)
);

-- Tabla de Servicios Adicionales (Para sumarle dificultad al proyecto)
CREATE TABLE servicios_adicionales (
    id_servicio int PRIMARY KEY AUTO_INCREMENT,
    id_reserva int NOT NULL,
    descripcion VARCHAR(100) NOT NULL, -- 'Desayuno Buffet', 'Servicio de Spa', 'Parking'
    precio_servicio DOUBLE NOT NULL,
    FOREIGN KEY (id_reserva) REFERENCES reservas(id_reserve) ON DELETE CASCADE
);

-- ==========================================
-- 2. INSERTS DE PRUEBA
-- ==========================================

-- Habitaciones disponibles en el hotel
INSERT INTO habitaciones (numero_habitacion, tipo, precio_noche, estado) VALUES 
('101', 'Individual', 45.00, 'Disponible'),
('102', 'Doble', 75.00, 'Ocupada'),
('201', 'Suite', 150.00, 'Disponible');

-- Algunos huéspedes registrados
INSERT INTO huespedes (nombre_completo, documento_identidad, telefono) VALUES 
('Elena Gómez', '12345678A', '+34 600112233'),
('Alejandro Ruiz', '87654321B', '+34 655443322');

-- Reservas hechas por los usuarios seleccionando fechas
-- Reserva 1: Elena se queda 3 noches en la Suite (201) en Mayo
INSERT INTO reservas (id_huesped, id_habitacion, fecha_entrada, fecha_salida, monto_total, estado_reserva) VALUES 
(1, 3, '2026-05-10', '2026-05-13', 450.00, 'Confirmada');

-- Reserva 2: Alejandro se queda 1 noche en la Doble (102) en Junio
INSERT INTO reservas (id_huesped, id_habitacion, fecha_entrada, fecha_salida, monto_total, estado_reserva) VALUES 
(2, 2, '2026-06-01', '2026-06-02', 75.00, 'Pendiente');

-- Servicios adicionales cargados a la reserva de Elena (Reserva 1)
INSERT INTO servicios_adicionales (id_reserva, descripcion, precio_servicio) VALUES 
(1, 'Desayuno Buffet (3 días)', 30.00),
(1, 'Acceso al Spa', 25.00);