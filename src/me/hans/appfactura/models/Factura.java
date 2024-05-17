package me.hans.appfactura.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

    private Cliente cliente;
    private ItemFactura[] items;
    private int folio;
    private String descripcion;
    private Date fecha;
    private int indiceItems;
    public static final int MAX_ITEMS = 10;
    private static int ultimoFolio;


    public Factura(Cliente cliente, String descripcion) {
        this.cliente = cliente;
        this.descripcion = descripcion;
        items = new ItemFactura[MAX_ITEMS];
        folio = ++ultimoFolio;
        fecha = new Date();
    }

    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ItemFactura[] getItems() {
        return items;
    }

    public void addItemFactura(ItemFactura item) {
        if (indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        }
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (ItemFactura item : this.items) {
            if (item == null) {
                continue;
            }
            total += item.calcularImporte();
        }
        return total;
    }

    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura Nª");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIF: ")
                .append(cliente.getNif())
                .append("\nDescripción: ")
                .append(this.descripcion)
                .append("\n");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha de emisión: ")
                .append(dateFormat.format(this.fecha))
                .append("\n")
                .append("\n#\t\tNombre\t\t$\t\tCant.\t\tTotal\n");
        for (ItemFactura item : this.getItems()) {
            if (item == null) {
                continue;
            }
            sb.append(item).append("\n");
        }
        sb.append("Gran Total: ").append(calcularTotal());
        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}