package EP1;
import java.io.*;
import java.util.*;

public class Gestor {
    private File archivo;

    public Gestor(String rutaArchivo) {
        this.archivo = new File(rutaArchivo);
        crearArchivoConCabecera();
    }

    private void crearArchivoConCabecera() {
        if (!archivo.exists()) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
                pw.printf("%-10s%-7s%-7s%-7s%-7s%n", "NOMBRE", "VIDA", "ATAQUE", "DEFENSA", "ALCANCE");
                pw.printf("%-10s%-7s%-7s%-7s%-7s%n", "Caballero", "4", "2", "4", "2");
                pw.printf("%-10s%-7s%-7s%-7s%-7s%n", "Guerrero", "2", "4", "2", "4");
                pw.printf("%-10s%-7s%-7s%-7s%-7s%n", "Arquero", "2", "4", "1", "8");
            } catch (IOException e) {
                System.err.println("Error al crear archivo: " + e.getMessage());
            }
        }
    }

    public void agregar(Personaje nuevo) {
        if (existePersonaje(nuevo.getNombre())) {
            System.out.println("El personaje '" + nuevo.getNombre() + "' ya existe.");
            return;
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {
            pw.println(nuevo.toFileLine());
            System.out.println("Personaje agregado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al agregar personaje: " + e.getMessage());
        }
    }

    private boolean existePersonaje(String nombreBuscado) {
        try (Scanner sc = new Scanner(archivo)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine().trim();
                if (linea.isEmpty() || linea.startsWith("NOMBRE")) continue;
                String nombre = linea.substring(0, 10).trim();
                if (nombre.equalsIgnoreCase(nombreBuscado)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error al verificar personaje: " + e.getMessage());
        }
        return false;
    }

    public void mostrar() {
        if (!archivo.exists()) return;
        try (Scanner sc = new Scanner(archivo)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.isEmpty()) continue;
                System.out.println(linea);
            }
        } catch (Exception e) {
            System.err.println("Error al leer archivo: " + e.getMessage());
        }
    }

    public void modificar(String nombre, int vida, int ataque, int defensa, int alcance) {
        File temp = new File("temp.txt");
        boolean modificado = false;

        try (Scanner sc = new Scanner(archivo);
             PrintWriter pw = new PrintWriter(new FileWriter(temp))) {

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.isEmpty()) continue;
                if (linea.startsWith("NOMBRE")) {
                    pw.println(linea);
                    continue;
                }
                String nombreArchivo = linea.substring(0, 10).trim();
                if (nombreArchivo.equalsIgnoreCase(nombre)) {
                    Personaje mod = new Personaje(nombre, vida, ataque, defensa, alcance);
                    pw.println(mod.toFileLine());
                    modificado = true;
                } else {
                    pw.println(linea);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al modificar personaje: " + e.getMessage());
        }

        if (modificado) {
            archivo.delete();
            temp.renameTo(archivo);
            System.out.println("Personaje modificado correctamente.");
        } else {
            temp.delete();
            System.out.println("No se encontró el personaje '" + nombre + "'.");
        }
    }

    public void eliminar(String nombre) {
        File temp = new File("temp.txt");
        boolean eliminado = false;

        try (Scanner sc = new Scanner(archivo);
             PrintWriter pw = new PrintWriter(new FileWriter(temp))) {

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.isEmpty()) continue;
                if (linea.startsWith("NOMBRE")) {
                    pw.println(linea);
                    continue;
                }
                String nombreArchivo = linea.substring(0, 10).trim();
                if (nombreArchivo.equalsIgnoreCase(nombre)) {
                    eliminado = true;
                } else {
                    pw.println(linea);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar personaje: " + e.getMessage());
        }

        if (eliminado) {
            archivo.delete();
            temp.renameTo(archivo);
            System.out.println("Personaje eliminado correctamente.");
        } else {
            temp.delete();
            System.out.println("No se encontró el personaje '" + nombre + "'.");
        }
    }
}
