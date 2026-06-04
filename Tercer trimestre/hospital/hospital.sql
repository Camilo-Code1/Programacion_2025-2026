DROP DATABASE IF EXISTS hospital_practica;
CREATE DATABASE IF NOT EXISTS hospital_practica;
USE hospital_practica;

-- ==========================================
-- 1. CREACIÓN DE TABLAS (HERENCIA Y RELACIONES)
-- ==========================================

-- TABLA PADRE: Personal del hospital
CREATE TABLE personal (
    id_personal int PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    dni_empleado VARCHAR(20) NOT NULL UNIQUE,
    telefono VARCHAR(20),
    tipo_personal VARCHAR(20) NOT NULL -- 'Medico' o 'Enfermero' (Ayuda a identificar el tipo en Java)
);

-- TABLA HIJA 1: Médicos
CREATE TABLE medicos (
    id_personal int PRIMARY KEY, -- NO es Auto_Increment, hereda el ID de la tabla personal
    especialidad VARCHAR(50) NOT NULL,
    licencia_medica VARCHAR(30) NOT NULL UNIQUE,
    FOREIGN KEY (id_personal) REFERENCES personal(id_personal) ON DELETE CASCADE
);

-- TABLA HIJA 2: Enfermeros
CREATE TABLE enfermeros (
    id_personal int PRIMARY KEY, -- Hereda el ID de la tabla personal
    turno VARCHAR(20) NOT NULL, -- 'Matutino', 'Vespertino', 'Nocturno'
    area_asignada VARCHAR(50) NOT NULL, -- 'Urgencias', 'Pediatría', etc.
    FOREIGN KEY (id_personal) REFERENCES personal(id_personal) ON DELETE CASCADE
);

-- Tabla de Pacientes
CREATE TABLE pacientes (
    id_paciente int PRIMARY KEY AUTO_INCREMENT,
    nombre_completo VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    historial_clinico TEXT
);

-- Tabla de Citas Médicas
CREATE TABLE citas_medicas (
    id_cita int PRIMARY KEY AUTO_INCREMENT,
    id_paciente int NOT NULL,
    id_medico int NOT NULL, -- Apunta al id_personal del médico
    fecha_cita DATE NOT NULL, -- Para DatePicker
    hora_cita TIME NOT NULL,  -- Para un ComboBox de horas (ej. '10:30:00')
    motivo VARCHAR(255),
    estado VARCHAR(20) DEFAULT 'Pendiente', -- 'Pendiente', 'Completada', 'Cancelada'
    FOREIGN KEY (id_paciente) REFERENCES pacientes(id_paciente),
    FOREIGN KEY (id_medico) REFERENCES medicos(id_personal)
);

-- ==========================================
-- 2. INSERTS DE PRUEBA (Respetando la Herencia)
-- ==========================================

-- Insertar Médico 1 (Paso 1: Datos generales, Paso 2: Datos específicos)
INSERT INTO personal (nombre, dni_empleado, telefono, tipo_personal) 
VALUES ('Dr. Gregory House', 'MED1234', '555-0199', 'Medico');
INSERT INTO medicos (id_personal, especialidad, licencia_medica) 
VALUES (1, 'Diagnóstico Clínico', 'LIC-99988');

-- Insertar Médico 2
INSERT INTO personal (nombre, dni_empleado, telefono, tipo_personal) 
VALUES ('Dra. Meredith Grey', 'MED5678', '555-0244', 'Medico');
INSERT INTO medicos (id_personal, especialidad, licencia_medica) 
VALUES (2, 'Cirugía General', 'LIC-77766');

-- Insertar Enfermero 1
INSERT INTO personal (nombre, dni_empleado, telefono, tipo_personal) 
VALUES ('Enf. Carla Espinosa', 'ENF1122', '555-0311', 'Enfermero');
INSERT INTO enfermeros (id_personal, turno, area_asignada) 
VALUES (3, 'Matutino', 'Urgencias');

-- Pacientes
INSERT INTO pacientes (nombre_completo, fecha_nacimiento, historial_clinico) VALUES 
('John Doe', '1985-04-12', 'Paciente con migrañas crónicas.'),
('Jane Smith', '1992-09-25', 'Control post-operatorio.');

-- Citas Médicas (El ID del médico debe corresponder a uno existente en la tabla medicos)
INSERT INTO citas_medicas (id_paciente, id_medico, fecha_cita, hora_cita, motivo) VALUES 
(1, 1, '2026-06-10', '10:00:00', 'Dolor de cabeza severo y alucinaciones'),
(2, 2, '2026-06-11', '16:30:00', 'Revisión de puntos de sutura');

SELECT * FROM personal;
SELECT * FROM medicos;
SELECT * FROM citas_medicas;