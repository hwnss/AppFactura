package me.hans.appfactura;

import me.hans.appfactura.models.*;

import java.util.Scanner;

public class AppFactura {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Cliente cliente = new Cliente();
        cliente.setNombre("Jon Doe");
        cliente.setNif("5555-555-55");

        System.out.print("Ingrese una descripción de la factura: ");
        Factura factura = new Factura(cliente, sc.nextLine());

        Producto producto;

        for (int i = 0; i < 2; i++) {
            producto = new Producto();

            System.out.print("Ingrese un producto: ");
            producto.setNombre(sc.next());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(sc.nextFloat());

            System.out.print("Ingrese la cantidad de productos: ");
            factura.addItemFactura(new ItemFactura(producto, sc.nextInt()));

            System.out.println();
        }
        System.out.println(factura);
    }
}
