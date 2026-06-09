package org.example.practtiendabasic.model;

import org.example.practtiendabasic.configuration.SQLDataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class SQLModelTipo {

  public static List<Tipo> getAllTipos(){
      List<Tipo> listaTipos = new LinkedList<>();

      String sql = "SELECT * FROM Tipo";

      try (Connection con = SQLDataAccess.getConnection();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql)){

          while (rs.next()){
              int idTipo = rs.getInt("idTipo");
              String Tipo = rs.getString("Tipo");
              listaTipos.add(new Tipo(idTipo, Tipo));
          }

      }catch (SQLException e) {
          System.err.println("Error en Tipos: " + e.getMessage());
      }
      return listaTipos;
  }


}
