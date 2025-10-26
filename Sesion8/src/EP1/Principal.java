package EP1;

import java.sql.*;
import java.util.Scanner;
import java.util.Random;

public class Principal {
    private static final String DB_URL = "jdbc:sqlite:alumnos.db";
    private static final String CLAVE = "notas2025";

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(DB_URL);
            crearTabla(conn);
            mostrarMenu(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void crearTabla(Connection conn) throws SQLException {
        String sql = """
            CREATE TABLE IF NOT EXISTS alumno (
                codigo TEXT PRIMARY KEY,
                nombre TEXT NOT NULL,
                teorialp3 REAL,
                practicalp3 REAL,
                promedio REAL
            )
        """;
        try (Statement st = conn.createStatement()) {
            st.execute(sql);
        }
    }

    private static void mostrarMenu(Connection conn) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nMENÚ DE ALUMNOS");
            System.out.println("1. Ingresar alumno");
            System.out.println("2. Mostrar alumnos");
            System.out.println("3. Actualizar notas");
            System.out.println("4. Borrar alumno");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> insertarAlumno(conn, sc);
                case 2 -> mostrarAlumnos(conn);
                case 3 -> actualizarAlumno(conn, sc);
                case 4 -> borrarAlumno(conn, sc);
                case 5 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 5);
    }

    private static void insertarAlumno(Connection conn, Scanner sc) throws SQLException {
        conn.setAutoCommit(false);
        Random rand = new Random();

        String codigo = "202400" + (1000 + rand.nextInt(9000)); 
        System.out.println("Código asignado: " + codigo);

        System.out.print("Ingrese nombre del alumno: ");
        String nombre = sc.nextLine();

        double teoria = pedirNota(sc, "Lenguajes de programación 3: Teoría");
        double practica = pedirNota(sc, "Lenguajes de Programación 3: Práctica");
        double promedio = (teoria+practica) / 2.0;

        String sql = "INSERT INTO alumno VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, codigo);
            ps.setString(2, nombre);
            ps.setDouble(3, teoria);
            ps.setDouble(4, practica);
            ps.setDouble(5, promedio);

            ps.executeUpdate();

            if (confirmarOperacion(sc)) {
                conn.commit();
                System.out.println("Alumno guardado correctamente.");
            } else {
                conn.rollback();
                System.out.println("Operación cancelada.");
            }
        }
        conn.setAutoCommit(true);
    }

    private static void mostrarAlumnos(Connection conn) throws SQLException {
        String sql = "SELECT * FROM alumno";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\nLISTA DE ALUMNOS");
            while (rs.next()) {
                System.out.printf("""
                        Código: %s
                        Nombre: %s
                        Teoría: %.1f
                        Práctica: %.1f
                        Promedio: %.2f
                		\n
                        """,
                        rs.getString("codigo"), rs.getString("nombre"), rs.getDouble("teorialp3"), rs.getDouble("practicalp3"), rs.getDouble("promedio"));
            }
        }
    }

    private static void actualizarAlumno(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Ingrese el código del alumno a actualizar: ");
        String codigo = sc.nextLine();

        double teoria = pedirNota(sc, "Lenguajes de programación 3: Teoría");
        double practica = pedirNota(sc, "Lenguajes de Programación 3: Práctica");
        double promedio = (teoria+practica) / 2.0;

        conn.setAutoCommit(false);
        String sql = """
            UPDATE alumno
            SET teorialp3=?, practicalp3=?, promedio=?
            WHERE codigo=?
        """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, teoria);
            ps.setDouble(2, practica);
            ps.setDouble(3, promedio);
            ps.setString(4, codigo);

            int filas = ps.executeUpdate();

            if (filas == 0) {
                System.out.println("No se encontró un alumno con ese código.");
                conn.rollback();
            } else if (confirmarOperacion(sc)) {
                conn.commit();
                System.out.println("Notas actualizadas correctamente.");
            } else {
                conn.rollback();
                System.out.println("Operación cancelada.");
            }
        }
        conn.setAutoCommit(true);
    }

    private static void borrarAlumno(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Ingrese el código del alumno a eliminar: ");
        String codigo = sc.nextLine();

        conn.setAutoCommit(false);
        String sql = "DELETE FROM alumno WHERE codigo=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, codigo);
            int filas = ps.executeUpdate();

            if (filas == 0) {
                System.out.println("No existe un alumno con ese código.");
                conn.rollback();
            } else if (confirmarOperacion(sc)) {
                conn.commit();
                System.out.println("Alumno eliminado correctamente.");
            } else {
                conn.rollback();
                System.out.println("Operación cancelada.");
            }
        }
        conn.setAutoCommit(true);
    }

    private static double pedirNota(Scanner sc, String curso) {
        double nota;
        do {
            System.out.print("Ingrese nota de "+ curso +" (0-20): ");
            nota = sc.nextDouble();
            sc.nextLine();
            if (nota < 0 || nota > 20) {
                System.out.println("Nota inválida. Debe estar entre 0 y 20.");
            }
        } while (nota < 0 || nota > 20);
        return nota;
    }

    private static boolean confirmarOperacion(Scanner sc) {
        System.out.print("Ingrese la clave para confirmar: ");
        String clave = sc.nextLine();
        return clave.equals(CLAVE);
    }
}
