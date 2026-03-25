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

                TipoProducto tipoProducto = new TipoProducto(nombre);
                mapaTipos.put(id, tipoProducto);
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar los tipos de productos: " + e.getMessage());

        }

    }


    public static List<String> getNombresProductos() {
        List<String> listaFormateada = new LinkedList<>();

        String sqlCommand = "SELECT referencia, nombre FROM Productos";

        try (Connection connection = SQLDataAccess.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlCommand)) {

            while (resultSet.next()) {
                String ref = resultSet.getString("referencia");
                String nombre = resultSet.getString("nombre");

                listaFormateada.add(String.format("\n[Referencia: %s, Nombre: %s]", ref, nombre));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los nombres de clientes: " + e.getMessage());
        }
        return listaFormateada;
    }

    public static List<TipoProducto> getNombresTipos() {
        List<TipoProducto> listaFormateada = new LinkedList<>();

        String sqlCommand = "SELECT id, nombre FROM Tipos";

        try (Connection connection = SQLDataAccess.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlCommand)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");

                TipoProducto tipoProducto = new TipoProducto(id ,nombre);
                listaFormateada.add(tipoProducto);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los nombres de tipos: " + e.getMessage());
        }
        return listaFormateada;
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



    public static Productos obtenerProductoPorID(int id) {
        Productos productoEncontrado = null;
        String com = "SELECT * FROM Productos WHERE id = ?";

        try (Connection connection = SQLDataAccess.getConnection();
             PreparedStatement statement = connection.prepareStatement(com)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // NO vuelvas a poner "int id =" aquí.
                    // Simplemente lee el resto de columnas:
                    String referencia = resultSet.getString("referencia");
                    String nombre = resultSet.getString("nombre");
                    String descripcion = resultSet.getString("descripcion");
                    TipoProducto tipo = mapaTipos.get(resultSet.getInt("tipo_id"));
                    int cantidad = resultSet.getInt("cantidad");
                    double precio = resultSet.getDouble("precio");
                    int descuento = resultSet.getInt("descuento");
                    int iva = resultSet.getInt("iva");
                    boolean aplicar_dto = resultSet.getBoolean("aplicar_dto");

                    // Usamos el CONSTRUCTOR 1 (el que tiene ID)
                    productoEncontrado = new Productos(id, referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicar_dto);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el producto por ID: " + e.getMessage());
        }
        return productoEncontrado;
    }
    public static List<Productos> obtenerProductosPorTipo(int idTipo) {
        List<Productos> lista = new ArrayList<>();
        // Buscamos en la tabla Productos, no en la de Tipos
        String sql = "SELECT * FROM Productos WHERE tipo_id = ?";

        try (Connection connection = SQLDataAccess.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, idTipo);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // Importante: necesitamos el objeto TipoProducto para el constructor
                    TipoProducto tipo = obtenerTipoPorID(idTipo);

                    Productos p = new Productos(
                            rs.getInt("id"), // Aquí sí pasamos el ID de la BD
                            rs.getString("referencia"),
                            rs.getString("nombre"),
                            rs.getString("descripcion"),
                            tipo,
                            rs.getInt("cantidad"),
                            rs.getDouble("precio"),
                            rs.getInt("descuento"),
                            rs.getInt("iva"),
                            rs.getBoolean("aplicar_dto")
                    );
                    lista.add(p);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar productos por tipo: " + e.getMessage());
        }
        return lista;
    }
    public static TipoProducto obtenerTipoPorID(int id){
        TipoProducto tipoProducto = null;

        String com = "SELECT * FROM Tipos WHERE id = ?";

        try(Connection connection = SQLDataAccess.getConnection();
            PreparedStatement statement = connection.prepareStatement(com)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){

                int idTipo = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");

                tipoProducto = new TipoProducto(idTipo, nombre);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el tipo por ID: " + e.getMessage());
        }
        return tipoProducto;
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

    public static void insertarProducto(Productos producto) {


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

            statement.executeUpdate();

            System.out.println("Producto insertado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar el producto: " + e.getMessage());
        }

    }

    public static int insertarTipoProducto(TipoProducto tipoProducto) {
        int filasAfectadas = -1;

        String sql = "INSERT INTO Tipos (nombre) VALUES (?)";

        try (Connection connection = SQLDataAccess.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tipoProducto.getNombre());

            filasAfectadas = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar el tipo de producto: " + e.getMessage());
        }
        return filasAfectadas;
    }



}
