package org.example.practtiendabasic.model;

import org.example.practtiendabasic.configuration.SQLDataAccess;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SQLModelMedicos {

    public static List<medicos> getAllMedicos() {
        List<medicos> lista = new LinkedList<>();

        String sql = "SELECT p.id_personal, p.nombre, p.dni_empleado, p.telefono, p.tipo_personal, " +
                "m.especialidad, m.licencia_medica " +
                "FROM personal p " +
                "INNER JOIN medicos m ON p.id_personal = m.id_personal";

        try (Connection con = SQLDataAccess.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                medicos med = new medicos(
                        rs.getInt("id_personal"),       // ← añadir esto
                        rs.getString("nombre"),
                        rs.getString("dni_empleado"),
                        rs.getString("telefono"),
                        TipoPersonal.valueOf(rs.getString("tipo_personal")),
                        rs.getString("especialidad"),
                        rs.getString("licencia_medica")
                );
                lista.add(med);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener médicos: " + e.getMessage());
        }

        return lista;
    }

    public static boolean createMedico(medicos m) {

        final String sqlPersonal = "INSERT INTO personal (nombre, dni_empleado, telefono, tipo_personal) " +
                "VALUES (?, ?, ?, 'Medico')";
        final String sqlMedico   = "INSERT INTO medicos (id_personal, especialidad, licencia_medica) " +
                "VALUES (?, ?, ?)";

        try (Connection con = SQLDataAccess.getConnection()) {
            con.setAutoCommit(false);

            int idGenerado;
            try (PreparedStatement psPersonal = con.prepareStatement(sqlPersonal,
                    Statement.RETURN_GENERATED_KEYS)) {
                psPersonal.setString(1, m.getNombre());
                psPersonal.setString(2, m.getDni_empleado());
                psPersonal.setString(3, m.getTelefono());
                psPersonal.executeUpdate();

                try (ResultSet rs = psPersonal.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGenerado = rs.getInt(1);
                    } else {
                        throw new SQLException("No se generó ID para personal.");
                    }
                }
            }

            try (PreparedStatement psMedico = con.prepareStatement(sqlMedico)) {
                psMedico.setInt(1, idGenerado);
                psMedico.setString(2, m.getEspecialidad());
                psMedico.setString(3, m.getLicencia_medica());
                psMedico.executeUpdate();
            }

            con.commit();
            return true;

        } catch (SQLException e) {
            System.err.println("Rollback aplicado: " + e.getMessage());
            return false;
        }
    }

    public static boolean updateMedico(medicos m) {

        final String sqlPersonal = "UPDATE personal SET nombre = ?, telefono = ? " +
                "WHERE dni_empleado = ?";
        final String sqlMedico   = "UPDATE medicos SET especialidad = ?, licencia_medica = ? " +
                "WHERE id_personal = (SELECT id_personal FROM personal WHERE dni_empleado = ?)";

        try (Connection con = SQLDataAccess.getConnection()) {
            con.setAutoCommit(false);

            try (PreparedStatement psPersonal = con.prepareStatement(sqlPersonal)) {
                psPersonal.setString(1, m.getNombre());
                psPersonal.setString(2, m.getTelefono());
                psPersonal.setString(3, m.getDni_empleado()); // DNI como clave de búsqueda
                psPersonal.executeUpdate();
            }

            try (PreparedStatement psMedico = con.prepareStatement(sqlMedico)) {
                psMedico.setString(1, m.getEspecialidad());
                psMedico.setString(2, m.getLicencia_medica());
                psMedico.setString(3, m.getDni_empleado());
                psMedico.executeUpdate();
            }

            con.commit();
            return true;

        } catch (SQLException e) {
            System.err.println("Rollback aplicado: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteMedico(String dniEmpleado) {

        // CASCADE en la BD se encarga de borrar también en medicos automáticamente
        final String sql = "DELETE FROM personal WHERE dni_empleado = ?";

        try (Connection con = SQLDataAccess.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dniEmpleado);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al borrar médico: " + e.getMessage());
            return false;
        }
    }
    public static boolean tieneCitas(medicos m) {
        String sql = "SELECT COUNT(*) FROM citas_medicas cm " +
                "INNER JOIN medicos med ON cm.id_medico = med.id_personal " +
                "INNER JOIN personal p ON med.id_personal = p.id_personal " +
                "WHERE p.dni_empleado = ?";

        try (Connection con = SQLDataAccess.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, m.getDni_empleado());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0; // true si tiene al menos una cita
            }

        } catch (SQLException e) {
            System.err.println("Error al comprobar citas: " + e.getMessage());
        }
        return false;
    }



}
