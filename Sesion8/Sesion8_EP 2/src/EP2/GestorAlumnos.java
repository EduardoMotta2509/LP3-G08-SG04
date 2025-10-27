package EP2;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class GestorAlumnos {

    private List<Alumno> listaAlumnos = new ArrayList<>();

    // Cargar los registros desde la base de datos
    public void cargarDesdeBD(Connection conn) throws SQLException {
        listaAlumnos.clear();
        String sql = "SELECT * FROM alumno";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Alumno a = new Alumno(
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getDouble("teorialp3"),
                        rs.getDouble("practicalp3"),
                        rs.getDouble("promedio")
                );
                listaAlumnos.add(a);
            }
        }
        System.out.println("Registros cargados en memoria: " + listaAlumnos.size());
    }

    // Mostrar menú interactivo
    public void mostrarMenu() {
        if (listaAlumnos.isEmpty()) {
            System.out.println("No hay alumnos cargados. Carga primero desde la base de datos.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- MENÚ DE CONSULTA (EN MEMORIA) ---");
            System.out.println("1. Mostrar todos los alumnos");
            System.out.println("2. Filtrar por condición");
            System.out.println("3. Ordenar por campo");
            System.out.println("4. Limitar cantidad de registros");
            System.out.println("5. Salir al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> mostrarTodos();
                case 2 -> filtrar(sc);
                case 3 -> ordenar(sc);
                case 4 -> limitar(sc);
                case 5 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 5);
    }

    // Mostrar todos los alumnos
    private void mostrarTodos() {
        System.out.println("\n--- LISTA COMPLETA DE ALUMNOS ---");
        listaAlumnos.forEach(a -> System.out.println(a.toString()));
    }

    // Filtrar por condición (por ejemplo promedio > 15)
    private void filtrar(Scanner sc) {
        System.out.print("Ingrese el campo a filtrar (nombre/promedio/teoria/practica): ");
        String campo = sc.nextLine().toLowerCase();

        System.out.print("Ingrese el operador (>, <, =, contiene): ");
        String op = sc.nextLine().toLowerCase();

        System.out.print("Ingrese el valor: ");
        String valor = sc.nextLine();

        List<Alumno> filtrados = listaAlumnos.stream()
                .filter(a -> cumpleCondicion(a, campo, op, valor))
                .collect(Collectors.toList());

        System.out.println("\n--- RESULTADO DEL FILTRO ---");
        if (filtrados.isEmpty())
            System.out.println("No se encontraron resultados.");
        else
            filtrados.forEach(a -> System.out.println(a.toString()));
    }

    // Ordenar ascendente o descendente
    private void ordenar(Scanner sc) {
        System.out.print("Ordenar por campo (nombre/promedio/teoria/practica): ");
        String campo = sc.nextLine().toLowerCase();
        System.out.print("Tipo de orden (asc/desc): ");
        String tipo = sc.nextLine().toLowerCase();

        Comparator<Alumno> comp = obtenerComparador(campo);
        if (comp == null) {
            System.out.println("Campo no válido.");
            return;
        }
        if (tipo.equals("desc")) comp = comp.reversed();

        listaAlumnos.sort(comp);
        System.out.println("\n--- ALUMNOS ORDENADOS ---");
        listaAlumnos.forEach(a -> System.out.println(a.toString()));
    }

    // Limitar la cantidad de registros a mostrar
    private void limitar(Scanner sc) {
        System.out.print("Ingrese el número máximo de registros a mostrar: ");
        int limite = sc.nextInt();
        sc.nextLine();

        List<Alumno> limitados = listaAlumnos.stream()
                .limit(limite)
                .collect(Collectors.toList());

        System.out.println("\n--- PRIMEROS " + limite + " ALUMNOS ---");
        limitados.forEach(a -> System.out.println(a.toString()));
    }

    // Verifica si un alumno cumple una condición
    private boolean cumpleCondicion(Alumno a, String campo, String operador, String valor) {
        try {
            return switch (campo) {
                case "promedio" -> compararNumeros(a.getPromedio(), operador, Double.parseDouble(valor));
                case "teoria" -> compararNumeros(a.getTeorialp3(), operador, Double.parseDouble(valor));
                case "practica" -> compararNumeros(a.getPracticalp3(), operador, Double.parseDouble(valor));
                case "nombre" -> operador.equals("contiene") && a.getNombre().toLowerCase().contains(valor.toLowerCase());
                default -> false;
            };
        } catch (Exception e) {
            return false;
        }
    }

    private boolean compararNumeros(double a, String operador, double b) {
        return switch (operador) {
            case ">" -> a > b;
            case "<" -> a < b;
            case "=" -> a == b;
            default -> false;
        };
    }

    private Comparator<Alumno> obtenerComparador(String campo) {
        return switch (campo) {
            case "nombre" -> Comparator.comparing(Alumno::getNombre);
            case "promedio" -> Comparator.comparingDouble(Alumno::getPromedio);
            case "teoria" -> Comparator.comparingDouble(Alumno::getTeorialp3);
            case "practica" -> Comparator.comparingDouble(Alumno::getPracticalp3);
            default -> null;
        };
    }
}

