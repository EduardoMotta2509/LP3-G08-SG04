package Controlador;

import Modelo.*;
import Vista.*;
import java.util.Scanner;

public class InventarioControlador {
    private InventarioModel modelo;
    private InventarioVista vista;
    private Scanner sc;
    private Jugador jugador;

    public InventarioControlador(InventarioModel modelo, InventarioVista vista, Jugador jugador) {
        this.modelo = modelo;
        this.vista = vista;
        this.sc = new Scanner(System.in);
        this.jugador=jugador;
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("MENÚ ");
            System.out.println("1. Agregar item");
            System.out.println("2. Eliminar item");
            System.out.println("3. Ver inventario");
            System.out.println("4. Buscar item y mostrar detalles");
            System.out.println("5. Equipar item");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                	agregarItem();
                	break;
                case 2:
                	eliminarItem();
                	break;
                case 3:
                	verInventario();
                	break;
                case 4:
                	mostrarDetallesBuscarItem();
                	break;
                case 5:
                	equiparItem();
                case 0:
                	vista.mostrarMensaje("Saliendo del sistema de inventario...");
                	break;
                default:
                	vista.mostrarMensaje("Opción inválida.");
                	break;
            }
        } while (opcion != 0);
    }

    private void agregarItem() {
        System.out.print("Nombre del item: ");
        String nombre = sc.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        System.out.print("Tipo (Arma/Poción): ");
        String tipo = sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();
        

        modelo.agregarItem(new Item(nombre, cantidad, tipo, descripcion));
        vista.mostrarMensaje("Item agregado exitosamente.");
    }

    private void eliminarItem() {
        System.out.print("Ingrese el nombre del item a eliminar: ");
        String nombre = sc.nextLine();
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            modelo.eliminarItem(item);
            vista.mostrarMensaje("Item eliminado.");
        } else {
            vista.mostrarMensaje("Item no encontrado.");
        }
    }

    private void verInventario() {
        vista.mostrarInventario(modelo.obtenerItems());
    }

    private void mostrarDetallesBuscarItem() {
        System.out.print("Ingrese el nombre del item a buscar: ");
        String nombre = sc.nextLine();
        Item item = modelo.buscarItem(nombre);
        vista.mostrarDetallesItem(item);
    }
    
    public void equiparItem() {
        System.out.print("Ingrese el nombre del item a usar: ");
        String nombre = sc.nextLine();
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            jugador.equiparArma(item); 
        } else {
            vista.mostrarMensaje("Item no encontrado.");
        }
    }

}