package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SQLAcessMercaDaw.cargarTiposDesdeBD();

//        SQLDataAccess accesoDatos = new SQLDataAccess();

        System.out.println(SQLAcessMercaDaw.getNombresProductos());

        System.out.println(SQLAcessMercaDaw.obtenerTodosLosProductos());





    }
}