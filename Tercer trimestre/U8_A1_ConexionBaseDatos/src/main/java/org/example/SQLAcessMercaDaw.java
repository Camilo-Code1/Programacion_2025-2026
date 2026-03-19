package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class SQLAcessMercaDaw {

    public static Map<Integer, TipoProducto> mapaTipos = new HashMap<>();

    public static void cargarTiposDesdeBD(){

        mapaTipos.clear();

        String sql = "SELECT id, nombre FROM Tipos";

        try (Connection connection = SQLDataAccess.getConnection();
             Statement smt = connection.createStatement();
        ResultSet resultSet = smt.executeQuery(sql)){

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");

                TipoProducto tipoProducto = new TipoProducto(id, nombre);
                mapaTipos.put(id, tipoProducto);
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar los tipos de productos: " + e.getMessage());

        }

    }


    public static List<String> getNombresProductos() {
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

    
    public static List<Productos> obtenerTodosLosProductos(){
        List<Productos> lista = new ArrayList<>();

        String sql = "SELECT * FROM Productos";

        try (Connection connection = SQLDataAccess.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {

                TipoProducto tipo = mapaTipos.get(resultSet.getInt("tipo_id"));

                Productos productos = new Productos(
                        resultSet.getInt("id"),
                        resultSet.getString("referencia"),
                        resultSet.getString("nombre"),
                        resultSet.getString("descripcion"),
                        tipo,
                        resultSet.getInt("cantidad"),
                        resultSet.getDouble("precio"),
                        resultSet.getInt("descuento"),
                        resultSet.getInt("iva"),
                        resultSet.getBoolean("aplicar_dto")
                );
                lista.add(productos);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los productos: " + e.getMessage());
        }
        return lista;

    }




}
