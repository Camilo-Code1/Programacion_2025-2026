package org.example;

import com.mysql.cj.xdevapi.PreparableStatement;

import javax.xml.transform.Result;
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
                    estilosCocina estilo = new estilosCocina(nombre);
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

                    estadosEntrega estadoEntrega = new estadosEntrega(estado);
                    mapaEstados.put(id, estadoEntrega);
                }

            } catch (Exception e) {
                System.out.println("Error al cargar estados de entrega: " + e.getMessage());
            }
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

        public static Platillos obtenerPedidosPorID(int id) {
            Platillos platilloEncontrado = null;

            String sql = "SELECT * FROM Platillos WHERE id = ?";

            try (Connection con = SQLDataAccess.getConnection();
            PreparedStatement stat = con.prepareStatement(sql)){

                stat.setInt(1, id);
                ResultSet rs = stat.executeQuery();

                if(rs.next()){

                    int idPedido = rs.getInt("id");
                    String nombre = rs.getString("nombre");

                    platilloEncontrado = new Platillos(idPedido, nombre);
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

        public static List<Platillos> mostrarPlatillos(){
            List<Platillos> list = new java.util.ArrayList<>();

            String sql = "SELECT * FROM Platillos";

            try (Connection con = SQLDataAccess.getConnection();
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery(sql)){

                while (rs.next()){

                    estilosCocina estilo = mapaEstilos.get(rs.getInt("id_estilo"));

                    Platillos platillo = new Platillos(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getDouble("precio"),
                            estilo
                    );
                    list.add(platillo);

                }

            } catch (Exception e) {
                System.out.println("Error al cargar platillos: " + e.getMessage());
            }
            return list;
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
        // Usamos LIKE para que si busca "Juan", encuentre a "Juan Pérez"
        String sql = "SELECT * FROM Pedidos WHERE cliente LIKE ?";

        try (Connection con = SQLDataAccess.getConnection();
             PreparedStatement sta = con.prepareStatement(sql)) {

            sta.setString(1, "%" + nombreCliente + "%");

            try (ResultSet rs = sta.executeQuery()) {
                // Usamos WHILE porque un cliente puede tener varios pedidos
                while (rs.next()) {
                    // 1. Sacamos los IDs de la base de datos
                    int idPedido = rs.getInt("id");
                    String cliente = rs.getString("cliente");
                    int idPlatilloDB = rs.getInt("id_platillo");
                    int idEstadoDB = rs.getInt("id_estado");

                    // 2. BUSCAMOS los objetos en nuestros Maps (Caché)
                    // Ojo: asegúrate de haber llamado a cargarPlatillos() y cargarEstados() antes
                    Platillos plato = mapaPlatillos.get(idPlatilloDB);
                    estadosEntrega estado = mapaEstados.get(idEstadoDB);

                    // 3. Extraemos la fecha/hora
                    // Convertimos el Timestamp de SQL a LocalTime de Java
                    LocalTime hora = rs.getTimestamp("fecha_pedido").toLocalDateTime().toLocalTime();

                    // 4. Creamos el objeto Pedido completo
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

}
