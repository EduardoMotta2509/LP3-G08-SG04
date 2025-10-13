package EP3Controlador;

import java.util.Scanner;
import EP3Modelo.Empleado;
import EP3Modelo.EmpleadoModelo;
import EP3Vista.EmpleadoVista;

public class EmpleadoControlador {
    private EmpleadoModelo modelo;
    private EmpleadoVista vista;
    private Scanner scanner;
    
    public EmpleadoControlador(EmpleadoModelo modelo, EmpleadoVista vista, Scanner scanner) {
        this.modelo = modelo;
        this.vista = vista;
        this.scanner = scanner;
    }
    
    public void listarEmpleados() {
        vista.mostrarEmpleados(modelo.leerEmpleados());
    }
    
    public void agregarEmpleado() {
        try {
            System.out.print("Ingrese el número del empleado: ");
            int numero = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Ingrese el nombre del empleado: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Ingrese el sueldo del empleado: ");
            double sueldo = scanner.nextDouble();
            scanner.nextLine();
            
            Empleado nuevoEmpleado = new Empleado(numero, nombre, sueldo);
            
            if (modelo.agregarEmpleado(nuevoEmpleado)) {
                vista.mostrarMensaje("Empleado agregado exitosamente.");
            } else {
                vista.mostrarMensaje("Error al agregar el empleado.");
            }
        } catch (Exception e) {
            vista.mostrarMensaje("Error en los datos ingresados: " + e.getMessage());
        }
    }
    
    public void buscarEmpleado() {
        try {
            System.out.print("Ingrese el número del empleado a buscar: ");
            int numero = scanner.nextInt();
            scanner.nextLine();
            
            Empleado empleado = modelo.buscarEmpleado(numero);
            vista.mostrarEmpleado(empleado);
        } catch (Exception e) {
            vista.mostrarMensaje("Error al buscar empleado: " + e.getMessage());
        }
    }
    
    public void eliminarEmpleado() {
        try {
            System.out.print("Ingrese el número del empleado a eliminar: ");
            int numero = scanner.nextInt();
            scanner.nextLine();
            
            if (modelo.eliminarEmpleado(numero)) {
                vista.mostrarMensaje("Empleado eliminado exitosamente.");
            } else {
                vista.mostrarMensaje("Empleado no encontrado.");
            }
        } catch (Exception e) {
            vista.mostrarMensaje("Error al eliminar empleado: " + e.getMessage());
        }
    }
}