package EP3Modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoModelo {
    private static final String ARCHIVO = "empleados.txt";
    
    public List<Empleado> leerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        File archivo = new File(ARCHIVO);
        
        if (!archivo.exists()) {
            return empleados;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().length() > 0) {
                    int numero = Integer.parseInt(linea.substring(0, 5).trim());
                    String nombre = linea.substring(5, 25).trim();
                    double sueldo = Double.parseDouble(linea.substring(25).trim());
                    empleados.add(new Empleado(numero, nombre, sueldo));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en el formato de datos: " + e.getMessage());
        }
        
        return empleados;
    }
    
    public boolean agregarEmpleado(Empleado nuevoEmpleado) {
        try (FileWriter fw = new FileWriter(ARCHIVO, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(nuevoEmpleado.toString());
            return true;
        } catch (IOException e) {
            System.out.println("Error al agregar empleado: " + e.getMessage());
            return false;
        }
    }
    
    public Empleado buscarEmpleado(int numero) {
        File archivo = new File(ARCHIVO);
        
        if (!archivo.exists()) {
            return null;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().length() > 0) {
                    int numArchivo = Integer.parseInt(linea.substring(0, 5).trim());
                    if (numArchivo == numero) {
                        String nombre = linea.substring(5, 25).trim();
                        double sueldo = Double.parseDouble(linea.substring(25).trim());
                        return new Empleado(numero, nombre, sueldo);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar empleado: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en el formato de datos: " + e.getMessage());
        }
        
        return null;
    }
    
    public boolean eliminarEmpleado(int numero) {
        File archivo = new File(ARCHIVO);
        
        if (!archivo.exists()) {
            return false;
        }
        
        List<Empleado> empleados = new ArrayList<>();
        boolean encontrado = false;
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().length() > 0) {
                    int numArchivo = Integer.parseInt(linea.substring(0, 5).trim());
                    if (numArchivo != numero) {
                        String nombre = linea.substring(5, 25).trim();
                        double sueldo = Double.parseDouble(linea.substring(25).trim());
                        empleados.add(new Empleado(numArchivo, nombre, sueldo));
                    } else {
                        encontrado = true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error en el formato de datos: " + e.getMessage());
            return false;
        }
        
        if (!encontrado) {
            return false;
        }
        
        try (FileWriter fw = new FileWriter(ARCHIVO);
             PrintWriter pw = new PrintWriter(fw)) {
            for (Empleado emp : empleados) {
                pw.println(emp.toString());
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error al eliminar empleado: " + e.getMessage());
            return false;
        }
    }
}