public class Producto {

    private String referencia;
    private String nombre;
    private String descripcion;
    private String tipo;
    private int cantidad;
    private double precio;
    private int descuento;
    private int iva;
    private boolean aplicardto;

    public Producto(String referencia, String nombre, String descripcion, String tipo) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.referencia = referencia;
        this.tipo = tipo;
    }

    public Producto(String referencia,String nombre, String descripcion, String tipo, int cantidad,
                    double precio, int descuento, int iva, boolean aplicardto){
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.aplicardto = aplicardto;
    }

    Producto(int cantidad, double precio, int descuento, int iva, boolean aplicardto) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.aplicardto = aplicardto;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getNombre(){
        return nombre;
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

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public void setAplicardto(boolean aplicardto) {
        this.aplicardto = aplicardto;
    }

    @Override
    public String toString() {
        return "<---Producto: " +
                "referencia: " + referencia  +
                " nombre: "+ nombre +
                ", descripcion: " + descripcion  +
                ", tipo: " + tipo +
                ", cantidad: " + cantidad +
                ", precio: " + precio +
                ", descuento: " + descuento +
                ", iva: " + iva +
                ", aplicardto: " + aplicardto +
                "--->";
    }
}
