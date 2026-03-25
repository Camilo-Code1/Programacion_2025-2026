package org.example;

import org.w3c.dom.CDATASection;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLDataAccess {

    public static Connection databaseLink;

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String SCHEMA = "MercaDaw";
    private static final String USUARIO = "developer";
    private static final String CLAVE = "developer";

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
            databaseLink = DriverManager.getConnection(URL + SCHEMA, USUARIO, CLAVE);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver JDBC: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }


        return databaseLink;
    }


    public List<String> getAllClientes() {
        List<String> nombresClientes = new ArrayList<>();
        String getCommand = "SELECT nombre FROM Productos";


        try (Connection connection = this.getConnection();
             Statement statement = (connection != null) ? connection.createStatement() : null) {

            if (statement == null) {
                return nombresClientes;
            }

            try (ResultSet dataSet = statement.executeQuery(getCommand)) {
                while (dataSet.next()) {

                    nombresClientes.add(dataSet.getString("nombre"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al obtener los clientes: " + e.getMessage());
        }

        return nombresClientes;
    }

    public void getAllProductos () {

        String getCommand = "SELECT * FROM Productos";

        try (Connection connection = SQLDataAccess.getConnection();
        Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(getCommand)) {

            while (dataSet.next()) {
                System.out.println("Producto: " + dataSet.getString("nombre"));
            }

        } catch (Exception e) {
            System.out.println("Error al obtener los productos: " + e.getMessage());

        }

    }
}


