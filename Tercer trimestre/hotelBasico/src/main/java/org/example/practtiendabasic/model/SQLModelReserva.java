package org.example.practtiendabasic.model;

import org.example.practtiendabasic.configuration.SQLDataAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLModelReserva {

    public static List<reservas> getAllReservas() {
        List<reservas> reservas = new ArrayList<>();

        String sql = "SELECT * FROM reservas";

        try (Connection con = SQLDataAccess.getConnection();
             Statement stat = con.createStatement();
             ResultSet rs = stat.executeQuery(sql)) {

            while (rs.next()) {
                reservas r = new reservas(
                        rs.getInt("id_reserve"),
                        rs.getInt("id_huesped"),
                        rs.getInt("id_habitacion"),
                        rs.getDate("fecha_entrada").toLocalDate(),
                        rs.getDate("fecha_salida").toLocalDate(),
                        rs.getDouble("monto_total"),
                        EstadoDeReserva.valueOf(rs.getString("estado_reserva"))
                );
                reservas.add(r);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener reservas: " + e.getMessage());
        }
        return reservas;
    }


    public static boolean createReserva(reservas r){
        String sql = "INSERT INTO reservas (id_huesped, id_habitacion, fecha_entrada, fecha_salida, monto_total, estado_reserva) VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection con = SQLDataAccess.getConnection();
            PreparedStatement st = con.prepareStatement(sql)){
            st.setInt(1, r.getId_huesped());
            st.setInt(2, r.getId_habitacion());
            st.setDate(3, Date.valueOf(r.getFecha_entrada()));
            st.setDate(4, Date.valueOf(r.getFecha_salida()));
            st.setDouble(5, r.getMonto_total());
            st.setString(6, r.getEstado_reserva().toString());

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al crear reserva: " + e.getMessage());
            return false;
        }
    }

        public static boolean deleteReserva(int id_reserve){
            String sql = "DELETE FROM reservas WHERE id_reserve = ?";

            try(Connection con = SQLDataAccess.getConnection();
                PreparedStatement st = con.prepareStatement(sql)){

                st.setInt(1, id_reserve);

                return st.executeUpdate() > 0;
            } catch (SQLException e) {
                System.err.println("Error al eliminar reserva: " + e.getMessage());
                return false;
            }
        }

        public static boolean updateReserva(reservas r){
            String sql = "UPDATE reservas SET id_huesped = ?, id_habitacion = ?, fecha_entrada = ?, fecha_salida = ?, monto_total = ?, estado_reserva = ? WHERE id_reserve = ?";

            try (Connection con = SQLDataAccess.getConnection();
                 PreparedStatement st = con.prepareStatement(sql)){

                st.setInt(1, r.getId_huesped());
                st.setInt(2, r.getId_habitacion());
                st.setDate(3, Date.valueOf(r.getFecha_entrada()));
                st.setDate(4, Date.valueOf(r.getFecha_salida()));
                st.setDouble(5, r.getMonto_total());
                st.setString(6, r.getEstado_reserva().toString());
                st.setInt(7, r.getId_reserve());

                return st.executeUpdate() > 0;
            } catch (SQLException e) {
                System.err.println("Error al actualizar reserva: " + e.getMessage());
                return false;

            }
        }

}
