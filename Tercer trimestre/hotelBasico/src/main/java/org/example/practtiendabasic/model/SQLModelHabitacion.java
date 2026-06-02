package org.example.practtiendabasic.model;

import org.example.practtiendabasic.configuration.SQLDataAccess;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SQLModelHabitacion {

    public static List<habitaciones> getAllHabitaciones(){
        List<habitaciones> listaHabitaciones = new LinkedList<>();

        String sql = "SELECT * FROM habitaciones";
            try (Connection con = SQLDataAccess.getConnection();
                 Statement stat = con.createStatement();
                 ResultSet rs = stat.executeQuery(sql)){

                while (rs.next()){
                    habitaciones h = new habitaciones(
                            rs.getInt("id_habitacion"),
                            rs.getString("numero_habitacion"),
                            tipoHabitacion.valueOf(rs.getString("tipo")),
                            rs.getDouble("precio_noche"),
                            estadoHab.valueOf(rs.getString("estado"))
                    );
                    listaHabitaciones.add(h);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener habitaciones: " + e.getMessage());
            }


        return listaHabitaciones;
    }

    public static boolean createHabitacioon (habitaciones h){
        String sql = "INSERT INTO habitaciones (numero_habitacion, tipo, precio_noche, estado) VALUES (?, ?, ?, ?)";

        try (Connection con = SQLDataAccess.getConnection();
        PreparedStatement st = con.prepareStatement(sql)){

            st.setString(1, h.getNumero_habitacion());
            st.setString(2, h.getTipo().toString());
            st.setDouble(3, h.getPrecio_noche());
            st.setString(4, h.getEstado().toString());

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al crear habitacion: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteHabitacion(int id_habitacion){
        String sql = "DELETE FROM habitaciones WHERE id_habitacion = ?";
        try (Connection con = SQLDataAccess.getConnection();
             PreparedStatement stat = con.prepareStatement(sql)){

            stat.setInt(1, id_habitacion);

            return stat.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar habitacion: " + e.getMessage());
            return false;
        }
    }

}
