package org.example;

import java.sql.*;
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

    public static Productos obtenerProductoPorID(int id){
        Productos productos = null;

        String com = "SELECT * FROM Productos WHERE id = ?";

        try(Connection connection = SQLDataAccess.getConnection();
            PreparedStatement statement = connection.prepareStatement(com)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){

                        resultSet.getInt("id");
                        String referencia = resultSet.getString("referencia");
                        String nombre = resultSet.getString("nombre");
                        String descripcion = resultSet.getString("descripcion");
                        TipoProducto tipo = mapaTipos.get(resultSet.getInt("tipo_id"));
                        int cantidad = resultSet.getInt("cantidad");
                        double precio = resultSet.getDouble("precio");
                        int descuento = resultSet.getInt("descuento");
                        int iva = resultSet.getInt("iva");
                        boolean aplicar_dto = resultSet.getBoolean("aplicar_dto");

                productos = new Productos(id, referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicar_dto);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el producto por ID: " + e.getMessage());
        }
        return productos;
    }

    public static int deleteProductoPorID(int id) {
        int filasAfectadas = 0;

        String sql = "DELETE FROM Productos WHERE id = ?";

        try (Connection connection = SQLDataAccess.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            filasAfectadas = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto por ID: " + e.getMessage());
        }
        return filasAfectadas;
    }

    public static int insertarProducto(Productos producto) {
        int filasAfectadas = -1;

        String sql = "INSERT INTO Productos (referencia, nombre, descripcion, tipo_id, cantidad, precio, descuento, iva, aplicar_dto) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = SQLDataAccess.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, producto.getReferencia());
            statement.setString(2, producto.getNombre());
            statement.setString(3, producto.getDescripcion());
            statement.setInt(4, producto.getTipo_id().getId());
            statement.setInt(5, producto.getCantidad());
            statement.setDouble(6, producto.getPrecio());
            statement.setInt(7, producto.getDescuento());
            statement.setInt(8, producto.getIva());
            statement.setBoolean(9, producto.isAplicar_dto());

            filasAfectadas = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar el producto: " + e.getMessage());
        }
        return filasAfectadas;
    }



}
