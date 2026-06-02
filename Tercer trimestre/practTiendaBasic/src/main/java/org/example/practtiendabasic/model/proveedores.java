package org.example.practtiendabasic.model;

public class proveedores {

    private int id_proveedor;
    private String nombre_empresa;
    private String contacto;

    public proveedores(int id_proveedor, String nombre_empresa, String contacto){
        this.id_proveedor = id_proveedor;
        this.nombre_empresa = nombre_empresa;
        this.contacto = contacto;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public String getContacto() {
        return contacto;
    }

    @Override
    public String toString() {
        return "Proveedores" +
                " ID proveedor: " + id_proveedor +
                " Nombre empresa: " + nombre_empresa + '\'' +
                " Contacto: " + contacto;
    }
}
