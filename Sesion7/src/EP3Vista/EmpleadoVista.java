package EP3Vista;

import java.util.List;
import EP3Modelo.Empleado;

public class EmpleadoVista {
    public void mostrarMenu() {
        System.out.println("\nRegistro de empleados:");
        System.out.println("1. Listar todos los empleados");
        System.out.println("2. Agregar nuevo empleado");
        System.out.println("3. Buscar empleado por número");
        System.out.println("4. Eliminar empleado por número");
        System.out.println("5. Salir del programa");
        System.out.print("Ingrese opción: ");
    }
    
    public void mostrarEmpleados(List<Empleado> empleados) {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        
        System.out.println("\nNúm.  Nombre               Sueldo");
        for (Empleado emp : empleados) {
            System.out.println(emp);
        }
    }
    
    public void mostrarEmpleado(Empleado empleado) {
        if (empleado == null) {
            System.out.println("Empleado no encontrado.");
        } else {
            System.out.println("\nNúm.  Nombre               Sueldo");
            System.out.println(empleado);
        }
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}