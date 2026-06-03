package org.example.practtiendabasic.model;

import org.example.practtiendabasic.configuration.SQLDataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class SQLModelHuespedes {

    public static List<huespedes> getAllHuespedes() {

        List<huespedes> listaHuespedes = new LinkedList<>();

        String sql = "SELECT * FROM huespedes";

        try (Connection con = SQLDataAccess.getConnection();
             Statement stat = con.createStatement();
             ResultSet rs = stat.executeQuery(sql)) {

            while (rs.next()) {
                huespedes h = new huespedes(
                        rs.getInt("id_huesped"),
                        rs.getString("nombre_completo"),
                        rs.getString("documento_identidad"),
                        rs.getString("telefono")
                );
                listaHuespedes.add(h);
            }

        } catch (Exception e) {
            System.err.println("Error al obtener huespedes: " + e.getMessage());
        }

        return listaHuespedes;
    }

}
