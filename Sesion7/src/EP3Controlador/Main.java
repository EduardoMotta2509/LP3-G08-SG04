package EP3Controlador;

import java.util.Scanner;
import EP3Modelo.EmpleadoModelo;
import EP3Vista.EmpleadoVista;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmpleadoModelo modelo = new EmpleadoModelo();
        EmpleadoVista vista = new EmpleadoVista();
        EmpleadoControlador controlador = new EmpleadoControlador(modelo, vista, sc);
        
        int opcion;
        
        do {
            vista.mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch(opcion) {
                case 1:
                    controlador.listarEmpleados();
                    break;
                case 2:
                    controlador.agregarEmpleado();
                    break;
                case 3:
                    controlador.buscarEmpleado();
                    break;
                case 4:
                    controlador.eliminarEmpleado();
                    break;
                case 5:
                    System.out.println("Hasta luego, vuelve pronto!");
                    break;
                default:
                    System.out.println("Opción no válida, ingrese de nuevo");
                    break;
            }
            
        } while(opcion != 5);
        
        sc.close();
    }
}