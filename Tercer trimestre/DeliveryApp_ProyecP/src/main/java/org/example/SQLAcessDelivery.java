package org.example;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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

}
