package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class SQLAcessMercaDaw {

    public static List<String> getNombresClientes() {
        List<String> nombresClientes = new LinkedList<>();

        String sqlCommand = "SELECT nombre FROM Productos";

        try (Connection connection = SQLDataAccess.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlCommand)) {

            while (resultSet.next()) {
                nombresClientes.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los nombres de clientes: " + e.getMessage());
        }
        return nombresClientes;
    }

    



}
