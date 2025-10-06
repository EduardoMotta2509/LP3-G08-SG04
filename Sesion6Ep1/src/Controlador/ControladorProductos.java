package Controlador;

import java.util.Scanner;
import Modelo.Almacen;
import Modelo.Producto;
import Vista.MenuProductos;
import Vista.VistaProductos;

public class ControladorProductos {
    private Almacen almacen;
    private VistaProductos vistaProductos;
    private MenuProductos menuProductos;
    private Scanner sc;

    public ControladorProductos(Almacen almacen) {
        this.almacen = almacen;
        this.vistaProductos = new VistaProductos(almacen);
        this.menuProductos = new MenuProductos();
        this.sc = new Scanner(System.in);
    }

    public void menuProductos() {
        int opcion;
        do {
            menuProductos.mostrarMenu();
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                	agregarProducto();
                	break;
                case 2:
                	vistaProductos.verAlmacen();
                	break;
                case 3:
                	eliminarProducto();
                	break;
                case 0:
                	System.out.println("Regresando al menú principal...");
                	break;
                default:
                	System.out.println("Opción inválida.");
                	break;
            }
        } while (opcion != 0);
    }

    private void agregarProducto() {
        System.out.print("Ingrese nombre del producto: ");
        sc.nextLine();
        String nombre = sc.nextLine();
        System.out.print("Ingrese precio del producto: ");
        double precio = sc.nextDouble();
        int id = almacen.getAlmacen().size() + 1;

        almacen.agregarProducto(new Producto(nombre, precio, id));
        System.out.println("Producto agregado con éxito.");
    }

    private void eliminarProducto() {
        vistaProductos.verAlmacen();
        if (almacen.getAlmacen().isEmpty()) {
            System.out.println("No hay productos para eliminar.");
            return;
        }
        System.out.print("Ingrese el número del producto a eliminar (Número según el orden de la lista): ");
        int index = sc.nextInt();
        if (index > 0 && index <= almacen.getAlmacen().size()) {
            almacen.eliminarProducto(index);
            System.out.println("Producto eliminado con éxito.");
        } else {
            System.out.println("Número inválido.");
        }
    }
}