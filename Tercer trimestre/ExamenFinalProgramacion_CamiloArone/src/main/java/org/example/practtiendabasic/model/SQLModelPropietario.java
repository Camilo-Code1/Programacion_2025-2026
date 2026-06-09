package org.example.practtiendabasic.model;


import org.example.practtiendabasic.configuration.SQLDataAccess;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SQLModelPropietario {

    public static List<Propietario> getAllPropietarios() {
        List<Propietario> listaPropietarios = new LinkedList<>();

        final String sql = "SELECT * FROM Propietario";

        try (Connection con = SQLDataAccess.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()){
                Propietario p = new Propietario(
                        rs.getString("dni"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Telefono"),
                        rs.getString("Direcion"),
                        rs.getString("Email")
                );
                listaPropietarios.add(p);
            }

        } catch (SQLException e){
            System.err.println("Error al obtener Propietarios: " + e.getMessage());
        }


        return listaPropietarios;
    }

    public static boolean createPropietario (Propietario pro) {

        final String sql = "INSERT INTO Propietario (dni, Nombre, Apellido, Telefono, Direcion, Email) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = SQLDataAccess.getConnection();
             PreparedStatement st = con.prepareStatement(sql)){

            st.setString(1, pro.getDni());
            st.setString(2, pro.getNombre());
            st.setString(3, pro.getApellido());
            st.setString(4, pro.getTelefono());
            st.setString(5, pro.getDirecion());
            st.setString(6, pro.getEmail());

            st.executeUpdate();
            return true;

        } catch (SQLException e){
            System.err.println("Error al crear propietario:" + e.getMessage());
            return false;
        }
    }

    public static boolean updatePropietario(Propietario pro){
        final String sql = "UPDATE Propietario SET Nombre = ?, Apellido = ?, Telefono = ?, Direcion = ?, Email = ? WHERE dni = ?";

        try (Connection con = SQLDataAccess.getConnection();
        PreparedStatement st = con.prepareStatement(sql)){

            st.setString(1, pro.getNombre());
            st.setString(2, pro.getApellido());
            st.setString(3, pro.getTelefono());
            st.setString(4, pro.getDirecion());
            st.setString(5, pro.getEmail());

            st.setString(6, pro.getDni());

            st.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar Propietario: " + e.getMessage());
            return false;
        }
    }



    public static boolean deletePropietario(String dni){
        final String sql = "DELETE FROM Propietario WHERE dni = ?";

        try (Connection con = SQLDataAccess.getConnection();
        PreparedStatement st = con.prepareStatement(sql)){

            st.setString(1, dni);
            return st.executeUpdate() >0;

        } catch (SQLException e){
            System.err.println("Error al borrar Propietario: " + e.getMessage());
            return false;
        }
    }

    public static boolean tieneConsultas(Propietario pro){

        final String sql = "SELECT COUNT(*) FROM Consulta con" +
                "INNER JOIN Propietario pro ON con.dni = pro.dni";


        return false;
    }


}
