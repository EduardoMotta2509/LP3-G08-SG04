package EP2;

import java.io.*;
import java.util.*;

public class Funcionalidades {
    private File archivo;

    public Funcionalidades(Gestor g) {
        this.archivo = new File("personajes.txt");
    }

    public void filtrarPorAtributo(String atributo) {
        List<String> lineas = new ArrayList<>();

        try (Scanner sc = new Scanner(archivo)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.isEmpty() || linea.startsWith("NOMBRE")) continue;
                lineas.add(linea);
            }
        } catch (Exception e) {
            System.err.println("Error al leer archivo: " + e.getMessage());
            return;
        }

        int inicio = switch (atributo.toLowerCase()) {
            case "vida" -> 10;
            case "ataque" -> 17;
            case "defensa" -> 24;
            case "alcance" -> 31;
            default -> -1;
        };

        if (inicio == -1) {
            System.out.println("Atributo no válido.");
            return;
        }

        int fin = inicio + 7;
        
        lineas.sort((a, b) -> {
        	int valorA = Integer.parseInt(a.substring(inicio, fin).trim());
            int valorB = Integer.parseInt(b.substring(inicio, fin).trim());
            return Integer.compare(valorB, valorA);
        });
        System.out.printf("%-10s%-7s%-7s%-7s%-7s%n", "NOMBRE", "VIDA", "ATAQUE", "DEFENSA", "ALCANCE");
        for (String l : lineas) {
            System.out.println(l);
        }
    }
    
    public void mostrarEstadisticas() {
        int total = 0, vida = 0, ataque = 0, defensa = 0, alcance = 0;

        try (Scanner sc = new Scanner(archivo)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.isEmpty() || linea.startsWith("NOMBRE")) continue;
                total++;
                vida += Integer.parseInt(linea.substring(10, 17).trim());
                ataque += Integer.parseInt(linea.substring(17, 24).trim());
                defensa += Integer.parseInt(linea.substring(24, 31).trim());
                alcance += Integer.parseInt(linea.substring(31, 38).trim());
            }
        } catch (Exception e) {
            System.err.println("Error al calcular estadísticas: " + e.getMessage());
            return;
        }

        if (total == 0) {
            System.out.println("No hay personajes registrados.");
            return;
        }

        System.out.println("\nEstadisticas:");
        System.out.println("Total de personajes: " + total);
        System.out.println("Vida promedio: " + (vida / total));
        System.out.println("Ataque promedio: " + (ataque / total));
        System.out.println("Defensa promedio: " + (defensa / total));
        System.out.println("Alcance promedio: " + (alcance / total));
    }

    public void actualizarAtributo(String nombre, String atributo, int nuevoValor) {
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
                    int vida = Integer.parseInt(linea.substring(10, 17).trim());
                    int ataque = Integer.parseInt(linea.substring(17, 24).trim());
                    int defensa = Integer.parseInt(linea.substring(24, 31).trim());
                    int alcance = Integer.parseInt(linea.substring(31, 38).trim());

                    switch (atributo) {
                        case "vida" -> vida = nuevoValor;
                        case "ataque" -> ataque = nuevoValor;
                        case "defensa" -> defensa = nuevoValor;
                        case "alcance" -> alcance = nuevoValor;
                        default -> {
                            System.out.println("Atributo no válido.");
                            pw.println(linea);
                            continue;
                        }
                    }
                    Personaje p = new Personaje(nombre, vida, ataque, defensa, alcance);
                    pw.println(p.toFileLine());
                    modificado = true;
                } else {
                    pw.println(linea);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al modificar atributo: " + e.getMessage());
        }

        if (modificado) {
            archivo.delete();
            temp.renameTo(archivo);
            System.out.println("Atributo actualizado correctamente.");
        } else {
            temp.delete();
            System.out.println("No se encontró el personaje.");
        }
    }

    public void importar(String rutaImportar) {
        File importar = new File(rutaImportar);
        if (!importar.exists()) {
            System.out.println("El archivo no existe.");
            return;
        }

        try (Scanner sc = new Scanner(importar);
             PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.isEmpty() || linea.startsWith("NOMBRE")) continue;
                pw.println(linea);
            }
            System.out.println("Importación completada correctamente.");
        } catch (IOException e) {
            System.err.println("Error al importar: " + e.getMessage());
        }
    }

    public void subirNivel(String nombre, int niveles) {
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
                    int vida = Integer.parseInt(linea.substring(10, 17).trim());
                    int ataque = Integer.parseInt(linea.substring(17, 24).trim());
                    int defensa = Integer.parseInt(linea.substring(24, 31).trim());
                    int alcance = Integer.parseInt(linea.substring(31, 38).trim());

                    vida += niveles;
                    ataque += niveles;
                    defensa += niveles;
                    alcance += niveles;

                    if (vida > 99) vida = 99;
                    if (ataque > 99) ataque = 99;
                    if (defensa > 99) defensa = 99;
                    if (alcance > 99) alcance = 99;

                    Personaje p = new Personaje(nombre, vida, ataque, defensa, alcance);
                    pw.println(p.toFileLine());
                    modificado = true;
                } else {
                    pw.println(linea);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al subir nivel: " + e.getMessage());
        }

        if (modificado) {
            archivo.delete();
            temp.renameTo(archivo);
            System.out.println("Nivel aumentado correctamente.");
        } else {
            temp.delete();
            System.out.println("No se encontró el personaje.");
        }
    }
}