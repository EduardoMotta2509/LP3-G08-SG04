package EP4;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class ContadorPalabras {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();        
        boolean archivoValido = false;
        
        while (!archivoValido) {
            int resultado = fileChooser.showOpenDialog(null);
            
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivo = fileChooser.getSelectedFile();
                archivoValido = procesarArchivo(archivo);
            } else {
                System.out.println("No se seleccionó ningún archivo. Saliendo del programa.");
                break;
            }
            
            if (!archivoValido) {
                System.out.println("Por favor, seleccione otro archivo.");
            }
        }
    }

    private static boolean procesarArchivo(File archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            int totalLineas = 0;
            int totalPalabras = 0;
            int totalCaracteres = 0;
            Map<String, Integer> frecuenciaPalabras = new HashMap<>();
            
            String linea;
            while ((linea = reader.readLine()) != null) {
                totalLineas++;
                totalCaracteres += linea.length();
                
                List<String> palabras = extraerPalabras(linea);
                totalPalabras += palabras.size();
                
                for (String palabra : palabras) {
                    frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
                }
            }
            
            mostrarResultados(totalLineas, totalPalabras, totalCaracteres, frecuenciaPalabras);
            return true;
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo no fue encontrado: " + e.getMessage());
            return false;
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            return false;
        }
    }

    private static List<String> extraerPalabras(String texto) {
        List<String> palabras = new ArrayList<>();
        StringBuilder palabraActual = new StringBuilder();
        
        for (char c : texto.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                palabraActual.append(c);
            } else {
                if (palabraActual.length() > 0) {
                    palabras.add(palabraActual.toString().toLowerCase());
                    palabraActual.setLength(0);
                }
            }
        }
        
        if (palabraActual.length() > 0) {
            palabras.add(palabraActual.toString().toLowerCase());
        }
        
        return palabras;
    }

    private static void mostrarResultados(int totalLineas, int totalPalabras, int totalCaracteres, Map<String, Integer> frecuenciaPalabras) {
        System.out.println("\nEl archivo fue analizado:");
        System.out.println("Total de líneas: " + totalLineas);
        System.out.println("Total de palabras: " + totalPalabras);
        System.out.println("Total de caracteres: " + totalCaracteres);
        
        if (totalLineas > 0) {
            double promedio = (double) totalPalabras / totalLineas;
            System.out.println("Promedio de palabras por línea: "+promedio);
        } else {
            System.out.println("Promedio de palabras por línea: 0.00");
        }
        
        mostrarPalabrasFrecuentes(frecuenciaPalabras);
    }

    private static void mostrarPalabrasFrecuentes(Map<String, Integer> frecuenciaPalabras) {
        if (frecuenciaPalabras.isEmpty()) {
            System.out.println("No se encontraron palabras en el archivo.");
            return;
        }
        
        List<String> palabras = new ArrayList<>(frecuenciaPalabras.keySet());
        List<Integer> frecuencias = new ArrayList<>();
        
        for (String palabra : palabras) {
            frecuencias.add(frecuenciaPalabras.get(palabra));
        }
        
        for (int i = 0; i < frecuencias.size() - 1; i++) {
            for (int j = i + 1; j < frecuencias.size(); j++) {
                if (frecuencias.get(i) < frecuencias.get(j)) {
                    int tempFrec = frecuencias.get(i);
                    frecuencias.set(i, frecuencias.get(j));
                    frecuencias.set(j, tempFrec);
                    
                    String tempPal = palabras.get(i);
                    palabras.set(i, palabras.get(j));
                    palabras.set(j, tempPal);
                }
            }
        }
        
        System.out.println("\nPalabras frecuentes:");
        int limite = 5;
        for (int i = 0; i < limite; i++) {
            System.out.println((i + 1) + ". " + palabras.get(i) + " - " + frecuencias.get(i) + " ocurrencias");
        }
    }
}