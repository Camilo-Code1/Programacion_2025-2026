package org.example.practtiendabasic.model;

import org.example.practtiendabasic.configuration.SQLDataAccess;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SQLModelProducto {

    public static List<productos> getAllProductos() {
        List<productos> listaProductos = new LinkedList<>();
        String sql = "SELECT * FROM productos";

    try (Connection conn = SQLDataAccess.getConnection();
         Statement stat = conn.createStatement();
         ResultSet rs = stat.executeQuery(sql)){

        while (rs.next()){
            productos p = new productos(
                    rs.getInt("id_producto"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getInt("stock"),
                    rs.getInt("id_categoria"),
                    rs.getInt("id_proveedor")
            );
            listaProductos.add(p);
        }

        } catch (SQLException e) {
        System.err.println("Error al obtener productos: " + e.getMessage());
    }


        return listaProductos;
    }


    public static boolean createProducto (productos p) {
        String sql = "INSERT INTO productos (nombre, precio, stock, id_categoria, id_proveedor) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = SQLDataAccess.getConnection();
        PreparedStatement st = conn.prepareStatement(sql)){

            st.setString(1, p.getNombre());
            st.setDouble(2, p.getPrecio());
            st.setInt(3, p.getStock());
            st.setInt(4, p.getCategoriaSelec());
            st.setInt(5, p.getProveedorSelec());

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al crear producto: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteProducto (int id_producto){
        String sql = "DELETE FROM productos WHERE id_producto = ?";

        try (Connection con = SQLDataAccess.getConnection();
             PreparedStatement stat = con.prepareStatement(sql)){

            stat.setInt(1, id_producto);
            return stat.executeUpdate() > 0;
        } catch (SQLException e){
            System.err.println("Error al borrar producto: " + e.getMessage());
            return false;
        }
    }

    public static List<categorias> getAllCategorias(){
        List<categorias> listaCategorias = new LinkedList<>();
        String sql = "SELECT * FROM categorias";

        try (Connection conn = SQLDataAccess.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql)){

            while (rs.next()){
                int id = rs.getInt("id_categoria");
                String nombre = rs.getString("nombre");

                listaCategorias.add(new categorias(id, nombre));
            }

        }catch (SQLException e) {
            System.err.println("Error en getAllCategorias: " + e.getMessage());
        }
        return listaCategorias;

    }

    public static List<proveedores> getAllProveedorews(){
        List<proveedores> listaProveedores = new LinkedList<>();

        String sql = "SELECT * FROM proveedores";

        try (Connection con = SQLDataAccess.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql)){

            while (rs.next()){
                int id = rs.getInt("id_proveedor");
                String nombre_empresa = rs.getString("nombre_empresa");
                String contacto = rs.getString("contacto");

                listaProveedores.add(new proveedores(id, nombre_empresa, contacto));
            }

        } catch (SQLException e) {
            System.err.println("Error en Proveedores: " + e.getMessage());
        }
        return listaProveedores;
    }

    public static boolean updateProducto (productos p) {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, stock = ?, " +
                "id_categoria = ?, id_proveedor = ? WHERE id_producto = ?";

        try (Connection con = SQLDataAccess.getConnection();
        PreparedStatement st = con.prepareStatement(sql)){

            st.setString(1, p.getNombre());
            st.setDouble(2, p.getPrecio());
            st.setInt(3, p.getStock());
            st.setInt(4, p.getCategoriaSelec());
            st.setInt(5, p.getProveedorSelec());

            st.setInt(6, p.getId_producto());

            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar producto: " + e.getMessage());
            return false;
        }


    }


}
