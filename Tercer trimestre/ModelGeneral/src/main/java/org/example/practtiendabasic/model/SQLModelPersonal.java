package org.example.practtiendabasic.model;

import org.example.practtiendabasic.configuration.SQLDataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLModelPersonal {

    public static List<personal> getAllPersonal(){
        List<personal> listaPersonal = new ArrayList<>();

        String sql = "SELECT * FROM personal";

        try (Connection con = SQLDataAccess.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                personal p = new personal(
                        rs.getInt("id_personal"),
                        rs.getString("nombre"),
                        rs.getString("dni_empleado"),
                        rs.getString("telefono"),
                        TipoPersonal.valueOf(rs.getString("tipo_personal"))
                );
                listaPersonal.add(p);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener el personal: " + e.getMessage());
        }
        return listaPersonal;
    }


}
