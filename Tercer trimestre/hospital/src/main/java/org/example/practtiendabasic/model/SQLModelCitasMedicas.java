package org.example.practtiendabasic.model;

import org.example.practtiendabasic.configuration.SQLDataAccess;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SQLModelCitasMedicas {

        public static List<citas_medicas> getAllCitasMedicas(){
                List<citas_medicas> listaCitasMedicas = new LinkedList<>();

                String sql = "SELECT * FROM citas_medicas";

                try (Connection con = SQLDataAccess.getConnection();
                     Statement st = con.createStatement();
                     ResultSet rs = st.executeQuery(sql)){

                        while (rs.next()){
                                citas_medicas cita = new citas_medicas(
                                        rs.getInt("id_cita"),
                                        rs.getInt("id_paciente"),
                                        rs.getInt("id_medico"),
                                        rs.getDate("fecha_cita").toLocalDate(),
                                        rs.getTime("hora_cita").toLocalTime(),
                                        rs.getString("motivo"),
                                        EstadoEnum.valueOf(rs.getString("estado"))
                                );
                                listaCitasMedicas.add(cita);
                        }


                } catch (Exception e) {
                        System.err.println("Error al obtener citas médicas: " + e.getMessage());
                }
                return listaCitasMedicas;
        }

        public static boolean createCitaMedica (citas_medicas cita){
                String sql = "INSERT INTO citas_medicas (id_paciente, id_medico, fecha_cita, hora_cita, motivo) VALUES (?, ?, ?, ?, ?)";

                try (Connection con = SQLDataAccess.getConnection();
                     PreparedStatement st = con.prepareStatement(sql)){

                        st.setInt(1, cita.getId_paciente());
                        st.setInt(2, cita.getId_medico());
                        st.setDate(3, Date.valueOf(cita.getFecha_cita()));
                        st.setTime(4, Time.valueOf(cita.getHora_cita()));
                        st.setString(5, cita.getMotivo());

                        st.executeUpdate();
                        return true;
                } catch (Exception e) {
                        System.err.println("Error al crear cita médica: " + e.getMessage());
                        return false;
                }
        }

        public static boolean deleteCitaMedica(int id_cita) {
                String sql = "DELETE FROM citas_medicas WHERE id_cita = ?";

                try (Connection con = SQLDataAccess.getConnection();
                     PreparedStatement st = con.prepareStatement(sql)) {

                        st.setInt(1, id_cita);

                        return  st.executeUpdate() > 0;
                } catch (SQLException e) {
                        System.err.println("Error al eliminar cita médica: " + e.getMessage());
                        return false;
                }
        }

            public static boolean updateCitaMedica(citas_medicas cita) {
                    String sql = "UPDATE citas_medicas SET id_paciente = ?, id_medico = ?, fecha_cita = ?, hora_cita = ?, motivo = ?, estado = ? WHERE id_cita = ?";

                    try (Connection con = SQLDataAccess.getConnection();
                        PreparedStatement st = con.prepareStatement(sql)) {

                            st.setInt(1, cita.getId_paciente());
                            st.setInt(2, cita.getId_medico());
                            st.setDate(3, Date.valueOf(cita.getFecha_cita()));
                            st.setTime(4, Time.valueOf(cita.getHora_cita()));
                            st.setString(5, cita.getMotivo());
                            st.setString(6, cita.getEstado().name());

                            st.setInt(7, cita.getId_cita());

                            return st.executeUpdate() > 0;
                    } catch (SQLException e) {
                            System.err.println("Error al actualizar cita médica: " + e.getMessage());
                            return false;
                    }
            }
}
