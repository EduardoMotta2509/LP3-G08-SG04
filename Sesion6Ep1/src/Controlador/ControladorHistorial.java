package Controlador;

import java.util.Scanner;
import Modelo.HistorialCompras;
import Vista.MenuCompras;
import Vista.VistaHistorialdeCompras;

public class ControladorHistorial {
    private HistorialCompras historial;
    private VistaHistorialdeCompras vistaHistorial;
    private MenuCompras menuCompras;
    private Scanner sc;

    public ControladorHistorial(HistorialCompras historial) {
        this.historial = historial;
        this.vistaHistorial = new VistaHistorialdeCompras(historial);
        this.menuCompras = new MenuCompras();
        this.sc = new Scanner(System.in);
    }

    public void menuHistorial() {
        int opcion;
        do {
            menuCompras.mostrarMenu();
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                	vistaHistorial.verHistorial();
                	break;
                case 2:
                	verDetalle();
                	break;
                case 0:
                	System.out.println("Saliendo del historial...");
                	break;
                default:
                	System.out.println("Opción inválida.");
                	break;
            }
        } while (opcion != 0);
    }

    private void verDetalle() {
        System.out.print("Ingrese el número de la compra: ");
        int index = sc.nextInt();
        vistaHistorial.detalleCompra(index - 1);
    }
}