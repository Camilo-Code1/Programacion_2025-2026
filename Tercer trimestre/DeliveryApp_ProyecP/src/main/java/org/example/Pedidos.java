package org.example;

import java.time.LocalTime;

public class Pedidos {

    private int id;
    private String cliente;
    private Platillos id_platillo;
    private estadosEntrega id_estado;
    private LocalTime fecha_pedido;

    public Pedidos(int id, String cliente, Platillos id_platillo, estadosEntrega id_estado, LocalTime fecha_pedido) {
        this.id = id;
        this.cliente = cliente;
        this.id_platillo = id_platillo;
        this.id_estado = id_estado;
        this.fecha_pedido = fecha_pedido;
    }
    public Pedidos(String cliente, Platillos id_platillo, estadosEntrega id_estado) {
        this.cliente = cliente;
        this.id_platillo = id_platillo;
        this.id_estado = id_estado;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public Platillos getId_platillo() {
        return id_platillo;
    }

    public estadosEntrega getId_estado() {
        return id_estado;
    }

    public LocalTime getFecha_pedido() {
        return fecha_pedido;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setId_platillo(Platillos id_platillo) {
        this.id_platillo = id_platillo;
    }

    public void setId_estado(estadosEntrega id_estado) {
        this.id_estado = id_estado;
    }

    @Override
    public String toString() {
        String nombrePlato = (id_platillo != null) ? id_platillo.getNombre() : "Sin plato";
        double precioPlato = (id_platillo != null) ? id_platillo.getPrecio() : 0.0;
        String nombreEstado = (id_estado != null) ? id_estado.getEstado() : "Sin estado";

        return String.format(
                "\n| ID: %-3d | Cliente: %-15s | Plato: %-20s | Precio: %6.2f€ | Estado: %-12s | Hora: %-8s |",
                id,
                cliente,
                nombrePlato,
                precioPlato,
                nombreEstado,
                fecha_pedido
        );
    }
}
