package org.example.practtiendabasic.model;

import org.example.practtiendabasic.configuration.SQLDataAccess;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SQLModelEnfermeros {

        public static List<enfermeros> getAllEnfermeros(){
            List<enfermeros> listaEnfermeros = new LinkedList<>();

            String sql = "SELECT p.nombre, p.dni_empleado, p.telefono, p.tipo_personal, " +
                    "e.turno, e.area_asignada " +
                    "FROM personal p " +
                    "INNER JOIN enfermeros e ON p.id_personal = e.id_personal";

            try (Connection con = SQLDataAccess.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()){

                while (rs.next()) {
                    enfermeros enf = new enfermeros(
                            rs.getString("nombre"),
                            rs.getString("dni_empleado"),
                            rs.getString("telefono"),
                            TipoPersonal.valueOf(rs.getString("tipo_personal")),
                            rs.getString("turno"),
                            rs.getString("area_asignada")
                    );
                    listaEnfermeros.add(enf);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener médicos: " + e.getMessage());
            }


            return listaEnfermeros;
        }

        public static boolean createEnfermero(enfermeros en) {
            final String sqlPersonal = "INSERT INTO personal (nombre, dni_empleado, telefono, tipo_personal) " +
                    "VALUES (?, ?, ?, 'Enfermero')";
            final String sqlEnfermero = "INSERT INTO enfermeros (id_personal, turno, area_asignada) " +
                    "VALUES (?, ?, ?)";

            try (Connection con = SQLDataAccess.getConnection()) {
                con.setAutoCommit(false);

                int idGenerado;
                try (PreparedStatement psPersonal = con.prepareStatement(sqlPersonal,
                        Statement.RETURN_GENERATED_KEYS)) {
                    psPersonal.setString(1, en.getNombre());
                    psPersonal.setString(2, en.getDni_empleado());
                    psPersonal.setString(3, en.getTelefono());
                    psPersonal.executeUpdate();

                    try (ResultSet rs = psPersonal.getGeneratedKeys()) {
                        if (rs.next()) {
                            idGenerado = rs.getInt(1);
                        } else {
                            throw new SQLException("No se pudo obtener el ID generado para personal.");
                        }
                    }
                }

                try (PreparedStatement psEnfermero = con.prepareStatement(sqlEnfermero)) {
                    psEnfermero.setInt(1, idGenerado);
                    psEnfermero.setString(2, en.getTurno());
                    psEnfermero.setString(3, en.getArea_asignada());
                    psEnfermero.executeUpdate();
                }

                con.commit();

                return true;
            } catch (SQLException e) {
                System.err.println("Rollback aplicado: " + e.getMessage());
                return false;
            }
        }



}
