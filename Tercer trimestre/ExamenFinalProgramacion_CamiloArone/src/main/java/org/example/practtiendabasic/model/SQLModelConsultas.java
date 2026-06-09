package org.example.practtiendabasic.model;

import org.example.practtiendabasic.configuration.SQLDataAccess;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SQLModelConsultas {

    public static List<Consulta> getAllConsultas(){
        List<Consulta> listaConsultas = new LinkedList<>();

        final String sql = "SELECT * FROM Consulta";

        try (Connection con = SQLDataAccess.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)){

            while (rs.next()){
                Consulta c = new Consulta(
                        rs.getDate("Fecha").toLocalDate(),
                        rs.getInt("Duracion"),
                        rs.getString("Observaciones"),
                        rs.getString("Mascota_Pasaporte"),
                        rs.getString("Mascota_Propietario_dni")
                );
                listaConsultas.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error al obtener Consultas: " + e.getMessage());
        }
        return listaConsultas;
    }

    public static boolean createConsultas(Consulta con){
        final String sql = "INSERT INTO Consulta (Fecha, Duracion, Observaciones, Mascota_Pasaporte, Mascota_Propietario_dni) VALUES (?, ?, ?, ?, ?)";

        try (Connection cona = SQLDataAccess.getConnection();
        PreparedStatement std = cona.prepareStatement(sql)){

            std.setDate(1, Date.valueOf(con.getFecha()));
            std.setInt(2, con.getDuracion());
            std.setString(3, con.getObservaciones());
            std.setString(4, con.getMascota_Pasaporte());
            std.setString(5, con.getMascota_Propietario_dni());
            std.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al crear Consulta: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteConsulta (String Mascota_Propietario_dni){
        final String sql = "DELETE FROM Consulta WHERE Mascota_Propietario_dni = ?";

        try (Connection con = SQLDataAccess.getConnection();
             PreparedStatement st = con.prepareStatement(sql)){

            st.setString(1, Mascota_Propietario_dni);
            return st.executeUpdate() > 0;

        } catch (SQLException e){
            System.err.println("Error al borrar Consultas: " + e.getMessage());
            return false;
        }
    }
}
