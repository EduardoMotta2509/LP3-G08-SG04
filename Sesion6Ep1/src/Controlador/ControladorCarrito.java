package Controlador;

import java.util.ArrayList;
import java.util.Scanner;
import Modelo.*;
import Vista.*;

public class ControladorCarrito {
    private Almacen almacen;
    private Carrito carrito;
    private HistorialCompras historial;

    private VistaCarrito vistaCarrito;
    private MenuCarrito menuCarrito;
    private Scanner sc;

    public ControladorCarrito(Almacen almacen, Carrito carrito, HistorialCompras historial) {
        this.almacen = almacen;
        this.carrito = carrito;
        this.historial = historial;
        this.vistaCarrito = new VistaCarrito(carrito);
        this.menuCarrito = new MenuCarrito();
        this.sc = new Scanner(System.in);
    }

    public void menuCarrito() {
        int opcion;
        do {
            menuCarrito.mostrarMenu();
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                	agregarProducto();
                	break;
                case 2:
                	vistaCarrito.verCarrito();
                	break;
                case 3:
                	eliminarProducto();
                	break;
                case 4:
                	realizarCompra();
                	break;
                case 0:
                	System.out.println("Saliendo del carrito...");
                	break;
                default:
                	System.out.println("Opción inválida.");
                	break;
            }
        } while (opcion != 0);
    }

    public void agregarProducto() {
        System.out.println("Productos disponibles:");
        for (Producto p : almacen.getAlmacen()) {
            System.out.println(p);
        }
        System.out.print("Ingrese el ID del producto que desea agregar: ");
        int id = sc.nextInt();

        for (Producto p : almacen.getAlmacen()) {
            if (p.getId() == id) {
                carrito.agregarProducto(p);
                System.out.println("Producto agregado al carrito.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void eliminarProducto() {
        vistaCarrito.verCarrito();
        if (carrito.getProductos().isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }
        System.out.print("Ingrese el número del producto a eliminar (Número por orden en la lista): ");
        int index = sc.nextInt();
        carrito.eliminarProducto(index);
        System.out.println("Producto eliminado del carrito.");
    }

    public void realizarCompra() {
        if (carrito.getProductos().isEmpty()) {
            System.out.println("No hay productos en el carrito para comprar.");
            return;
        }
        double total = 0;
        for (Producto p : carrito.getProductos()) {
            total += p.getPrecio();
        }
        System.out.println("Aplica descuento? S/N");
        String dsct =sc.next();
        if (dsct.equals("S")) {
        	total=conDescuento(total);
        }
        Compra compra = new Compra(new ArrayList<>(carrito.getProductos()), total);
        historial.getHistorialCompras().add(compra);
        carrito.eliminar();
        System.out.println("Compra realizada con éxito. Total: S/." + total);
    }
    
    public double conDescuento(double neto) {
    	System.out.println("Ingrese porcentaje de descuento: ");
    	int dsc=sc.nextInt();
    	return neto-(neto*dsc/100);
    }
}