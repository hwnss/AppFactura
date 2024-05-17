package me.hans.appfactura.models;

public class ItemFactura {

    private Producto producto;
    private int cantidad;

    public ItemFactura(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public float calcularImporte() {
        return (float) (this.producto.getPrecio() * this.cantidad);
    }

    @Override
    public String toString() {
        return producto + "\t\t" + cantidad + "\t\t" + calcularImporte();
    }
}
