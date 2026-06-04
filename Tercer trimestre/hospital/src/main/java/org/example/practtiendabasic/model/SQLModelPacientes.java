package org.example.practtiendabasic.model;

import org.example.practtiendabasic.configuration.SQLDataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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


}
