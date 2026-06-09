package org.example.practtiendabasic.model;

import org.example.practtiendabasic.configuration.SQLDataAccess;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SQLModelMascotas {

    public static List<Mascota> getAllMascotas(){
        List<Mascota> listaMascotas = new LinkedList<>();

        final String sql = "SELECT * FROM Mascota";

        try (Connection con = SQLDataAccess.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)){

            while (rs.next()){
                Mascota m = new Mascota(
                        rs.getString("Pasaporte"),
                        rs.getString("Nombre"),
                        rs.getDouble("Peso"),
                        rs.getDate("FechaNacimiento").toLocalDate(),
                        rs.getString("Propietario_dni"),
                        rs.getInt("Tipo_idTipo")

                );
                listaMascotas.add(m);
            }

        } catch (Exception e) {
            System.err.println("Error al obtener Mascotas: " + e.getMessage());
        }
        return listaMascotas;
    }

    public static boolean createMascota(Mascota m){

        final String sql = "INSERT INTO Mascota (Pasaporte, Nombre, Peso, FechaNacimiento, Propietario_dni, Tipo_idTipo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = SQLDataAccess.getConnection();
             PreparedStatement st = con.prepareStatement(sql)){

            st.setString(1, m.getPasaporte());
            st.setString(2, m.getNombre());
            st.setDouble(3, m.getPeso());
            st.setDate(4, Date.valueOf(m.getFechaNacimiento()));
            st.setString(5, m.getPropietario_dni());
            st.setInt(6, m.getTipo_idTipo());

            st.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al crear Mascota: " + e.getMessage());
            return false;
        }
    }



    public static boolean deleteMascota(String Pasaporte){
        final String sql = "DELETE FROM Mascota WHERE Pasaporte = ?";

        try (Connection connection = SQLDataAccess.getConnection();
        PreparedStatement st = connection.prepareStatement(sql)) {

            st.setString(1, Pasaporte);
            return st.executeUpdate() > 0;

        } catch (SQLException e){
            System.err.println("Error al borrar Mascota: " + e.getMessage());
            return false;
        }
    }

}
