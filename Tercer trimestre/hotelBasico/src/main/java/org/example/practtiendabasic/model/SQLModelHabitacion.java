package org.example.practtiendabasic.model;

import org.example.practtiendabasic.configuration.SQLDataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
//                    rs.getInt("id_habitacion"),
//                    rs.getString("numero_habitacion"),
//

                }

            } catch (SQLException e) {
                System.err.println("Error al obtener habitaciones: " + e.getMessage());
            }


        return listaHabitaciones;
    }



}
