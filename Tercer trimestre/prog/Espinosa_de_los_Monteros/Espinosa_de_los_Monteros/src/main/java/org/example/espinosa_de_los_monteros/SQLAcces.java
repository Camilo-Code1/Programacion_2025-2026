package org.example.espinosa_de_los_monteros;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.StandardSocketOptions;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SQLAcces {

    public static void añadirPaciente(Paciente paciente) throws SQLException {
        String sql = "INSERT INTO Paciente (dni, Nombre, Apellidos, Telefono, Direccion, Email) Values (?, ?, ?, ?, ?, ?)";

        try(Connection connection = SQLManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, paciente.getDni());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getApellidos());
            ps.setString(4, paciente.getTelefono());
            ps.setString(5, paciente.getDireccion());
            ps.setString(6, paciente.getEmail());
            ps.executeUpdate();
        }
    }

    // ─── DOCTOR ──────────────────────────────────────────────

    public ObservableList<Doctor> cargarDoctores() throws SQLException {
        String sql = "SELECT * FROM Doctor";
        ObservableList<Doctor> doctores = FXCollections.observableArrayList();

        try (Connection con = SQLManager.getConnection();
             Statement statement = con.createStatement()) {

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Doctor d = new Doctor(
                        rs.getString("num_colegiado"),
                        rs.getString("Nombre"),
                        rs.getString("Apellidos"),
                        rs.getString("Telefono"),
                        rs.getString("Direccion"),
                        rs.getString("Email"),
                        rs.getString("fecha_alta"),
                        rs.getInt("TipoConsulta_id")
                );
                doctores.add(d);
            }
        }
        return doctores;
    }

    public void insertarDoctor(Doctor d) throws SQLException {
        String sql = "INSERT INTO Doctor (num_colegiado, Nombre, Apellidos, Telefono, Direccion, Email, fecha_alta, TipoConsulta_id) VALUES (?,?,?,?,?,?,?,?)";

        try (Connection con = SQLManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, d.getNumColegiado());
            ps.setString(2, d.getNombre());
            ps.setString(3, d.getApellidos());
            ps.setString(4, d.getTelefono());
            ps.setString(5, d.getDireccion());
            ps.setString(6, d.getEmail());
            ps.setDate(7, Date.valueOf(d.getFechaAlta()));
            ps.setInt(8, d.getTipoConsultaId());
            ps.executeUpdate();
        }
    }

    // ─── TIPO CONSULTA ───────────────────────────────────────

    public ObservableList<Tipo> cargarTiposConsulta() throws SQLException {
        String sql = "SELECT id, Tipo FROM TipoConsulta";
        ObservableList<Tipo> tipos = FXCollections.observableArrayList();

        try (Connection con = SQLManager.getConnection();
             Statement statement = con.createStatement()) {

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                tipos.add(new  Tipo(rs.getInt("id"), rs.getString("Tipo")));
            }
        }
        return tipos;
    }


    public int obtenerTipoConsultaDoctor(String doctorNumColegiado) throws SQLException {
        String sql = "SELECT TipoConsulta_id FROM Doctor WHERE num_colegiado = ?";
        try (Connection con = SQLManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, doctorNumColegiado);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("TipoConsulta_id");
            }
            throw new SQLException("Doctor no encontrado" +  doctorNumColegiado);
        }
    }

    public void insertarConsulta(Consulta c) throws SQLException {
        String sql = "INSERT INTO Consulta (Observaciones, fecha, TipoConsulta_id, Paciente_dni, Doctor_num_colegiado, Doctor_TipoConsulta_id) VALUES (?,?,?,?,?,?)";

        try (Connection con = SQLManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getObservaciones());
            ps.setDate(2, Date.valueOf(c.getFecha()));
            ps.setInt(3, c.getTipoConsultaId());
            ps.setString(4, c.getPacienteDni());
            ps.setString(5, c.getDoctorNumColegiado());
            ps.setInt(6, c.getDoctorTipoConsultaId());
            ps.executeUpdate();
        }
    }


    public Doctor buscarDoctorPorNumColegiado(String numColegiado) throws SQLException {
        String sql = "SELECT * FROM Doctor WHERE num_colegiado = ?";
        try (Connection con = SQLManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, numColegiado);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Doctor(
                        rs.getString("num_colegiado"),
                        rs.getString("Nombre"),
                        rs.getString("Apellidos"),
                        rs.getString("Telefono"),
                        rs.getString("Direccion"),
                        rs.getString("Email"),
                        rs.getString("fecha_alta"),
                        rs.getInt("TipoConsulta_id")
                );
            }
        }
        return null;
    }

    public void actualizarDoctor(Doctor d) throws SQLException {
        String sql = "UPDATE Doctor SET Nombre=?, Telefono=? WHERE num_colegiado=?";
        try (Connection con = SQLManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, d.getNombre());
            ps.setString(2, d.getTelefono());
            ps.setString(3, d.getNumColegiado());
            ps.executeUpdate();
        }
    }

    public void eliminarDoctor(String numC) throws SQLException {
        String sql = "DELETE FROM Doctor WHERE num_colegiado=?";
        try (Connection con = SQLManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, numC);
            ps.executeUpdate();
        }
    }

    // ─── EXPORTAR ────────────────────────────────────────────

    public void exportarPacientes(List<Paciente> pacientes, String ruta) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(pacientes);
        }
    }

    public ObservableList<Paciente> cargarDatosPacienteInicio() throws SQLException { //ESTO LOS CARGO PARA EL EXPORTAR
        String sql = "SELECT * FROM Paciente";
        ObservableList<Paciente> pacientes = FXCollections.observableArrayList();

        try (Connection con = SQLManager.getConnection();
             Statement statement = con.createStatement()) {

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Paciente p = new Paciente(
                        rs.getString("dni"),
                        rs.getString("Nombre"),
                        rs.getString("Apellidos"),
                        rs.getString("Telefono"),
                        rs.getString("Direccion"),
                        rs.getString("Email")
                );
                pacientes.add(p);
            }
        }
        return pacientes;
    }


}
