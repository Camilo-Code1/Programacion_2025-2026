package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SQLDataAccess accesoDatos = new SQLDataAccess();

        List<String> clientes = accesoDatos.getAllClientes();


        if (clientes.isEmpty()) {
            System.out.println("No se encontraron clientes o la tabla está vacía.");
        } else {
            System.out.println("Lista de clientes en la base de datos:");
            for (String nombre : clientes) {
                System.out.println("- " + nombre);
            }
        }


        accesoDatos.getAllProductos();

    }
}