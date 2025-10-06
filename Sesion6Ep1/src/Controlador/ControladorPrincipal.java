package Controlador;

import java.util.Scanner;
import Modelo.*;
import Vista.*;

public class ControladorPrincipal {
	private Almacen almacen;
    private Carrito carrito;
    private HistorialCompras historial;

    private ControladorProductos controladorProductos;
    private ControladorCarrito controladorCarrito;
    private ControladorHistorial controladorHistorial;
    private Menu menu;
    private Scanner sc;

    public ControladorPrincipal() {
        almacen = new Almacen();
        carrito = new Carrito();
        historial = new HistorialCompras();
        menu = new Menu();
        sc = new Scanner(System.in);

        controladorProductos = new ControladorProductos(almacen);
        controladorCarrito = new ControladorCarrito(almacen, carrito, historial);
        controladorHistorial = new ControladorHistorial(historial);

        cargarProductosIniciales();
    }

    private void cargarProductosIniciales() {
        almacen.agregarProducto(new Modelo.Producto("Laptop", 2500.0, 130));
        almacen.agregarProducto(new Modelo.Producto("Mouse", 60.0, 140));
        almacen.agregarProducto(new Modelo.Producto("Teclado", 120.0, 150));
        almacen.agregarProducto(new Modelo.Producto("Audífonos", 80.0, 160));
    }

    public void iniciar() {
        int opcion;
        do {
            menu.mostrarMenu();
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                	controladorProductos.menuProductos();
                	break;
                case 2:
                	controladorCarrito.menuCarrito();
                	break;
                case 3:
                	controladorCarrito.realizarCompra();
                	break;
                case 4:
                	controladorHistorial.menuHistorial();
                	break;
                case 0:
                	System.out.println("Gracias por visitar la Tienda del Mercader :)");
                	break;
                default:
                	System.out.println("Opción inválida");
                	break;
            }
        } while (opcion != 0);
    }
}

