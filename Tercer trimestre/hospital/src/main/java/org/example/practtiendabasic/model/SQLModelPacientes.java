package org.example.practtiendabasic.model;

import org.example.practtiendabasic.configuration.SQLDataAccess;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SQLModelPacientes {

    public static List<pacientes> getAllPacientes(){
        List<pacientes> listaPacientes = new LinkedList<>();

        String sql = "SELECT * FROM pacientes";

        try (Connection con = SQLDataAccess.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                pacientes p = new pacientes(
                        rs.getInt("id_paciente"),
                        rs.getString("nombre_completo"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getString("historial_clinico")
                );
                listaPacientes.add(p);
            }

            } catch (Exception e) {
            System.err.println("Error al obtener pacientes: " + e.getMessage());
         }
        return listaPacientes;
    }

    public static boolean createPacientes (pacientes pa){
        String sql = "INSERT INTO pacientes (nombre_completo, fecha_nacimiento, historial_clinico) VALUES (?, ?, ?)";

        try (Connection con = SQLDataAccess.getConnection();
             PreparedStatement st = con.prepareStatement(sql)){

            st.setString(1, pa.getNombre_completo());
            st.setDate(2, Date.valueOf(pa.getFecha_nacimiento()));
            st.setString(3, pa.getHistorial_clinico());
            st.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al crear paciente: " + e.getMessage());
            return false;
        }

    }

    public static boolean updatePaciente(pacientes pac) {
        final String sql = "UPDATE pacientes SET nombre_completo = ?, fecha_nacimiento = ?, historial_clinico = ? WHERE id_paciente = ?";

        try (Connection con = SQLDataAccess.getConnection();
        PreparedStatement st = con.prepareStatement(sql)){

            st.setString(1, pac.getNombre_completo());
            st.setDate(2, Date.valueOf(pac.getFecha_nacimiento()));
            st.setString(3, pac.getHistorial_clinico());

            st.setInt(4, pac.getId_paciente());

            st.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.err.println("Error al actualizar paciente: " + e.getMessage());
            return false;

        }

    }

    public static boolean deletePaciente(int id_paciente){
        final String sql = "DELETE FROM pacientes WHERE id_paciente = ?";

        try (Connection con = SQLDataAccess.getConnection();
        PreparedStatement st = con.prepareStatement(sql)){

            st.setInt(1, id_paciente);
            return st.executeUpdate() > 0;

        } catch (SQLException e){
            System.err.println("Error al borrar pacientes: " + e.getMessage());
            return false;
        }
    }


}
