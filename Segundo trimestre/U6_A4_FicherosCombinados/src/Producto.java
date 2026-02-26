public class Producto {

    private String referencia;
    private String descripcion;
    private String tipo;
    private int cantidad;
    private double precio;
    private int descuento;
    private int iva;
    private boolean aplicardto;

    public Producto(String referencia, String descripcion, String tipo, int cantidad,
                    double precio, int descuento, int iva, boolean aplicardto){
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.aplicardto = aplicardto;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDescuento() {
        return descuento;
    }

    public int getIva() {
        return iva;
    }

    public boolean isAplicardto() {
        return aplicardto;
    }

    @Override
    public String toString() {
        return "<---Producto: " +
                " referencia: " + referencia  +
                ", descripcion: " + descripcion  +
                ", tipo: " + tipo +
                ", cantidad: " + cantidad +
                ", precio: " + precio +
                ", descuento: " + descuento +
                ", iva:" + iva +
                ", aplicardto: " + aplicardto +
                "--->";
    }
}
