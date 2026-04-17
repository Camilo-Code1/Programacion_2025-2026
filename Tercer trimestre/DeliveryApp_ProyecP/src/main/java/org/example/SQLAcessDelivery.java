package org.example;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLAcessDelivery {

        public static Map<Integer, estilosCocina> mapaEstilos = new HashMap<>();

        public static Map<Integer, estadosEntrega> mapaEstados = new HashMap<>();

        public static Map<Integer, Platillos> mapaPlatillos = new HashMap<>();

        public static void cargarEstilos(){

            mapaEstilos.clear();

            String sql = "SELECT id, nombre FROM EstilosCocina";

            try(Connection connection = SQLDataAccess.getConnection();
                Statement smt = connection.createStatement();
                ResultSet rs = smt.executeQuery(sql)){

                while (rs.next()){
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");

                    estilosCocina estilo = new estilosCocina(id, nombre);
                    mapaEstilos.put(id, estilo);
                }


            } catch (Exception e) {
                System.out.println("Error al cargar estilos de cocina: " + e.getMessage());
            }

        }

        public static void cargarEstados() {

            mapaEstados.clear();

            String sql = "SELECT id, estado FROM EstadosEntrega";

            try (Connection connection = SQLDataAccess.getConnection();
                 Statement smt = connection.createStatement();
                 ResultSet rs = smt.executeQuery(sql)) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String estado = rs.getString("estado");

                    estadosEntrega estadoEntrega = new estadosEntrega(id, estado);
                    mapaEstados.put(id, estadoEntrega);
                }

            } catch (Exception e) {
                System.out.println("Error al cargar estados de entrega: " + e.getMessage());
            }
        }

        public static List<String> obtenerClientesConPedidos() {
        List<String> clientes = new ArrayList<>();
        String sql = "SELECT DISTINCT cliente FROM Pedidos";

        try (Connection con = SQLDataAccess.getConnection();
             Statement sta = con.createStatement();
             ResultSet rs = sta.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(rs.getString("cliente"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener lista de clientes: " + e.getMessage());
        }
        return clientes;
    }

        public static List<estadosEntrega> getNombresEstados() {
        return new ArrayList<>(mapaEstados.values());
        }

        public static List<Platillos> getNombresPlatillos() {
        return new ArrayList<>(mapaPlatillos.values());
        }

        public static List<estilosCocina> getNombresEstilos(){
            return new ArrayList<>(mapaEstilos.values());
        }


        public static List<Platillos> cargarPlatillos() {
        List<Platillos> list = new ArrayList<>();
        mapaPlatillos.clear();

        String sql = "SELECT * FROM Platillos";

        try (Connection con = SQLDataAccess.getConnection();
             Statement sta = con.createStatement();
             ResultSet rs = sta.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int idEstilo = rs.getInt("id_estilo");

                estilosCocina estilo = mapaEstilos.get(idEstilo);

                Platillos platillo = new Platillos(
                        id,
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        estilo
                );

                list.add(platillo);
                mapaPlatillos.put(id, platillo);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar platillos: " + e.getMessage());
        }
        return list;
    }

        public static Platillos obtenerPlatilloPorID(int id) {
            Platillos platilloEncontrado = null;

            String sql = "SELECT * FROM Platillos WHERE id = ?";

            try (Connection con = SQLDataAccess.getConnection();
            PreparedStatement stat = con.prepareStatement(sql)){

                stat.setInt(1, id);
                ResultSet rs = stat.executeQuery();

                if(rs.next()){

                    int idPedido = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    double precio = rs.getDouble("precio");
                    int idEstilo = rs.getInt("id_estilo");

                    platilloEncontrado = new Platillos(idPedido, nombre, precio, mapaEstilos.get(idEstilo));
                }

            } catch (SQLException e){
                System.out.println("Error al obtener pedidos: " + e.getMessage());
            }
            return platilloEncontrado;
        }

        public static estadosEntrega obtenerEstadoPorID(int id) {
        estadosEntrega estado = null;
        String sql = "SELECT * FROM EstadosEntrega WHERE id = ?";

        try (Connection con = SQLDataAccess.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                estado = new estadosEntrega(rs.getInt("id"), rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar estado: " + e.getMessage());
        }
        return estado;
    }

        public static estilosCocina obtenerEstiloPorID(int id) {
            estilosCocina estilo = null;

            String sql = "SELECT * FROM EstilosCocina WHERE id = ?";

            try (Connection con = SQLDataAccess.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    estilo = new estilosCocina(rs.getInt("id"), rs.getString("nombre"));
                }

            } catch (SQLException e) {
                System.out.println("Error al buscar estilo de cocina: " + e.getMessage());
            }
            return estilo;
        }

        public static List<Pedidos> mostrarPedidosPorEstado(int idEstado){
            List<Pedidos> filtrados = new ArrayList<>();
            String sql = "SELECT * FROM Pedidos WHERE id_estado = ?";

            try (Connection con = SQLDataAccess.getConnection();
                 PreparedStatement sta = con.prepareStatement(sql)) {

                sta.setInt(1, idEstado);
                ResultSet rs = sta.executeQuery();

                while (rs.next()) {

                    Platillos plato = mapaPlatillos.get(rs.getInt("id_platillo"));
                    estadosEntrega estado = mapaEstados.get(rs.getInt("id_estado"));
                    LocalTime hora = rs.getTimestamp("fecha_pedido").toLocalDateTime().toLocalTime();

                    Pedidos p = new Pedidos(rs.getInt("id"), rs.getString("cliente"), plato, estado, hora);
                    filtrados.add(p);
                }
            } catch (SQLException e) {
                System.out.println("Error al filtrar por estado: " + e.getMessage());
            }
            return filtrados;
        }

        public static List<Pedidos> cargarPedidos(){
            List<Pedidos> lista = new ArrayList<>();

            String sql = "SELECT * FROM Pedidos";

            try (Connection con = SQLDataAccess.getConnection();
            Statement sta = con.createStatement();
            ResultSet resultSet = sta.executeQuery(sql)){
                while (resultSet.next()){

                    int idPlatilloDB = resultSet.getInt("id_platillo");
                    int idEstadoDB = resultSet.getInt("id_estado");

                    Platillos platillo = mapaPlatillos.get(idPlatilloDB);
                    estadosEntrega estado = mapaEstados.get(idEstadoDB);

                    Pedidos pedido = new Pedidos(
                            resultSet.getInt("id"),
                            resultSet.getString("cliente"),
                            platillo,
                            estado,
                            resultSet.getTimestamp("fecha_pedido").toLocalDateTime().toLocalTime()
                    );
                    lista.add(pedido);
                }


            } catch (Exception e) {
                System.out.println("Error al cargar pedidos: " + e.getMessage());
            }
            return lista;
        }

        public static void insertarPedido(Pedidos pedido) {
            String sql = "INSERT INTO Pedidos (cliente, id_platillo, id_estado)" + "VALUES (?,?,?)";

            try (Connection con = SQLDataAccess.getConnection();
                 PreparedStatement sta = con.prepareStatement(sql)){

                sta.setString(1, pedido.getCliente());
                sta.setInt(2, pedido.getId_platillo().getId());
                sta.setInt(3, pedido.getId_estado().getId());

                sta.executeUpdate();

                System.out.println("Pedido agregado exitosamente");

            } catch (SQLException e){
                System.out.println("Error al insertar pedido: " + e.getMessage());
            }
        }

        public static List<Pedidos> obtenerPedidosPorNombre(String nombreCliente) {
        List<Pedidos> resultados = new ArrayList<>();

        String sql = "SELECT * FROM Pedidos WHERE cliente LIKE ?";

        try (Connection con = SQLDataAccess.getConnection();
             PreparedStatement sta = con.prepareStatement(sql)) {

            sta.setString(1, "%" + nombreCliente + "%");

            try (ResultSet rs = sta.executeQuery()) {

                while (rs.next()) {

                    int idPedido = rs.getInt("id");
                    String cliente = rs.getString("cliente");
                    int idPlatilloDB = rs.getInt("id_platillo");
                    int idEstadoDB = rs.getInt("id_estado");


                    Platillos plato = mapaPlatillos.get(idPlatilloDB);
                    estadosEntrega estado = mapaEstados.get(idEstadoDB);


                    LocalTime hora = rs.getTimestamp("fecha_pedido").toLocalDateTime().toLocalTime();

                    Pedidos pedido = new Pedidos(idPedido, cliente, plato, estado, hora);
                    resultados.add(pedido);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar pedidos por nombre: " + e.getMessage());
        }
        return resultados;
    }

        public static boolean eliminarPedido(String nombreCliente){
            boolean eliminado = false;

            String sql = "DELETE FROM Pedidos WHERE cliente LIKE ?";

            try (Connection con = SQLDataAccess.getConnection();
            PreparedStatement sta = con.prepareStatement(sql)){

                sta.setString(1, "%" + nombreCliente + "%");

                int rows = sta.executeUpdate();

                if (rows > 0){
                    System.out.println("Pedido eliminado exitosamente");
                    eliminado = true;
                } else {
                    System.out.println("Pedido no eliminado");
                }

            } catch (SQLException e) {
                System.out.println("Error al eliminar pedido: " + e.getMessage());
            }
            return eliminado;
    }

        public static void actualizarEstadoPedido(int idPedido, int nuevoIdEstado) {
            String sql = "UPDATE Pedidos SET id_estado = ? WHERE id = ?";

            try (Connection con = SQLDataAccess.getConnection();
                 PreparedStatement sta = con.prepareStatement(sql)) {

                sta.setInt(1, nuevoIdEstado);
                sta.setInt(2, idPedido);

                int rows = sta.executeUpdate();

                if (rows > 0) {
                    System.out.println("Estado del pedido actualizado exitosamente");
                } else {
                    System.out.println("No se encontró el pedido para actualizar");
                }

            } catch (SQLException e) {
                System.out.println("Error al actualizar estado del pedido: " + e.getMessage());
            }
        }

        public static void agregarEstiloCocina(estilosCocina estilo) {
            String sql = "INSERT INTO EstilosCocina (nombre) VALUES (?)";

            try (Connection con = SQLDataAccess.getConnection();
                 PreparedStatement sta = con.prepareStatement(sql)) {

                sta.setString(1, estilo.getNombre());
                sta.executeUpdate();

                System.out.println("Estilo de cocina agregado exitosamente");

            } catch (SQLException e) {
                System.out.println("Error al agregar estilo de cocina: " + e.getMessage());
            }
        }

        public static void insertarPlatillo(Platillos platillo){
            String sql = "INSERT INTO Platillos (nombre, precio, id_estilo) VALUES (?,?,?)";

            try (Connection con = SQLDataAccess.getConnection();
                 PreparedStatement sta = con.prepareStatement(sql)) {

                sta.setString(1, platillo.getNombre());
                sta.setDouble(2, platillo.getPrecio());
                sta.setInt(3, platillo.getId_estilo().getId());

                sta.executeUpdate();

                System.out.println("Platillo agregado exitosamente");

            } catch (SQLException e) {
                System.out.println("Error al agregar platillo: " + e.getMessage());
            }
        }

        public static void actualizarPlatillo(Platillos platillo, int idPlatillo) {
            String sql = "UPDATE Platillos SET nombre = ?, precio = ?, id_estilo = ? WHERE id = ?";

            try (Connection con = SQLDataAccess.getConnection();
                 PreparedStatement sta = con.prepareStatement(sql)) {

                sta.setString(1, platillo.getNombre());
                sta.setDouble(2, platillo.getPrecio());
                sta.setInt(3, platillo.getId_estilo().getId());
                sta.setInt(4, platillo.getId());

                int rows = sta.executeUpdate();

                if (rows > 0) {
                    System.out.println("Platillo actualizado exitosamente");
                } else {
                    System.out.println("No se encontró el platillo para actualizar");
                }

            } catch (SQLException e) {
                System.out.println("Error al actualizar platillo: " + e.getMessage());
            }
        }


        public static void generarReporteVentas() {
        double beneficiosHoy = 0;
        double previstoHoy = 0;
        int contadorPedidos = 0;

        String sql = "SELECT p.id_estado, pl.precio " +
                "FROM Pedidos p " +
                "JOIN Platillos pl ON p.id_platillo = pl.id " +
                "WHERE DATE(p.fecha_pedido) = CURDATE()";

        try (Connection con = SQLDataAccess.getConnection();
             Statement sta = con.createStatement();
             ResultSet rs = sta.executeQuery(sql)) {

            while (rs.next()) {
                int idEstado = rs.getInt("id_estado");
                double precio = rs.getDouble("precio");

                if (idEstado == 4) {
                    beneficiosHoy += precio;
                } else {
                    previstoHoy += precio;
                }
                contadorPedidos++;
            }

            System.out.println("\n*****************************************");
            System.out.println("   📊 REPORTE DE VENTAS - " + java.time.LocalDate.now());
            System.out.println("*****************************************");
            System.out.println(" Pedidos hoy: " + contadorPedidos);
            System.out.printf(" ✅ Beneficios reales:    %.2f€\n", beneficiosHoy);
            System.out.printf(" ⏳ Dinero previsto:      %.2f€\n", previstoHoy);
            System.out.println("-----------------------------------------");
            System.out.printf(" 📈 Total Proyectado:     %.2f€\n", (beneficiosHoy + previstoHoy));
            System.out.println("*****************************************\n");

        } catch (SQLException e) {
            System.out.println("Error al generar reporte: " + e.getMessage());
        }
    }

}
