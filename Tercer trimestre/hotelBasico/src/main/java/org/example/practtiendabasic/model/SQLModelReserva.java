package org.example.practtiendabasic.model;

import org.example.practtiendabasic.configuration.SQLDataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLModelReserva {

    public static List<reservas> getAllReservas() {
        List<reservas> reservas = new ArrayList<>();

        String sql = "SELECT * FROM reservas";

        try (Connection con = SQLDataAccess.getConnection();
             Statement stat = con.createStatement();
             ResultSet rs = stat.executeQuery(sql)) {

            while (rs.next()) {
                reservas r = new reservas(
                        rs.getInt("id_reserve"),
                        rs.getInt("id_huesped"),
                        rs.getInt("id_habitacion"),
                        rs.getDate("fecha_entrada").toLocalDate(),
                        rs.getDate("fecha_salida").toLocalDate(),
                        rs.getDouble("monto_total"),
                        EstadoDeReserva.valueOf(rs.getString("estado_reserva"))
                );
                reservas.add(r);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener reservas: " + e.getMessage());
        }
        return reservas;
    }


}
