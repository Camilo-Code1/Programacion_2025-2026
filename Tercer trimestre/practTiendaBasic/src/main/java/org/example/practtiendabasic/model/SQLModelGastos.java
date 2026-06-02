package org.example.practtiendabasic.model;

import org.example.practtiendabasic.configuration.SQLDataAccess;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SQLModelGastos {

    public static List<gastos> getAllGastos(){
        List<gastos> listaGastos = new LinkedList<>();
        String sql = "SELECT * FROM gastos";

        try (Connection con = SQLDataAccess.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

          while (rs.next()){
              gastos g = new gastos(
                      rs.getInt("id_gasto"),
                      rs.getString("concepto"),
                      rs.getDouble("monto"),
                      rs.getDate("fecha").toLocalDate(),
                      rs.getInt("id_proveedor")
              );
              listaGastos.add(g);
          }
        } catch (SQLException e) {
            System.err.println("Error al obtener gastos: " + e.getMessage());
        }
        return listaGastos;
    }

    public static boolean createGasto (gastos g) {
        String sql = "INSERT INTO gastos (concepto, monto, id_proveedor) VALUES (?, ?, ?)";

        try (Connection con = SQLDataAccess.getConnection();
             PreparedStatement st = con.prepareStatement(sql)){

            st.setString(1, g.getConcepto());
            st.setDouble(2, g.getMonto());
            st.setInt(3, g.getId_proveedor());

            st.executeUpdate();
            return true;
        }  catch (SQLException e) {
            System.err.println("Error al crear gasto: " + e.getMessage());
            return false;
        }

    }

    public static boolean updateGasto(gastos g){
        String sql = "UPDATE gastos SET concepto = ?, monto = ?, id_proveedor = ? WHERE id_gasto = ?";

        try (Connection con = SQLDataAccess.getConnection();
        PreparedStatement st = con.prepareStatement(sql)){

            st.setString(1, g.getConcepto());
            st.setDouble(2, g.getMonto());
            st.setInt(3, g.getId_proveedor());

            st.setInt(4, g.getId_gasto());

            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar gasto: " + e.getMessage());
            return false;
        }

    }



    public static boolean deleteGasto (int id_gasto){
        String sql = "DELETE FROM gastos WHERE id_gasto = ?";

        try (Connection con = SQLDataAccess.getConnection();
        PreparedStatement st = con.prepareStatement(sql)){

            st.setInt(1, id_gasto);
            return st.executeUpdate() > 0;

        } catch (SQLException e){
            System.err.println("Error al borrar gasto: " + e.getMessage());
            return false;
        }


    }


}
