package EPP;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void iniciar() {
        // Admin por defecto
        usuarios.add(new Usuario("admin@mail.com", "1234", Rol.ADMIN));
        System.out.println("Bienvenido al Sistema de Gestión de Reservas");
        menuLogin();
    }

    private void menuLogin() {
        while (true) {
            System.out.print("\nEmail: ");
            String email = sc.nextLine();
            System.out.print("Password: ");
            String pass = sc.nextLine();
            Usuario u = buscarUsuario(email, pass);
            if (u != null) {
                if (u.getRol() == Rol.ADMIN) menuAdmin(u);
                else menuUser(u);
            } else {
                System.out.println("Credenciales incorrectas.");
            }
        }
    }

    private Usuario buscarUsuario(String email, String pass) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email) && u.getPassword().equals(pass)) return u;
        }
        return null;
    }

    /* --------- ADMIN --------- */
    private void menuAdmin(Usuario admin) {
        while (true) {
            System.out.println("\n--- MENU ADMIN ---");
            System.out.println("1) Crear usuario");
            System.out.println("2) Crear habitación");
            System.out.println("3) Listar habitaciones");
            System.out.println("4) Listar usuarios");
            System.out.println("5) Listar reservas");
            System.out.println("6) Logout");
            String op = sc.nextLine();
            switch (op) {
                case "1": crearUsuario(); break;
                case "2": crearHabitacion(); break;
                case "3": listarHabitaciones(); break;
                case "4": listarUsuarios(); break;
                case "5": listarReservas(); break;
                case "6": return;
                default: System.out.println("Opción inválida");
            }
        }
    }

    private void crearUsuario() {
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        System.out.print("Rol (1=ADMIN, 2=USER): ");
        String rol = sc.nextLine();
        Rol r = rol.equals("1") ? Rol.ADMIN : Rol.USER;
        usuarios.add(new Usuario(email, pass, r));
        System.out.println("Usuario creado.");
    }

    private void crearHabitacion() {
        System.out.print("Tipo (1=Simple, 2=Doble): ");
        String t = sc.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.print("Max personas: ");
        int max = Integer.parseInt(sc.nextLine());
        if (t.equals("1")) {
            System.out.print("Número de camas: ");
            int camas = Integer.parseInt(sc.nextLine());
            habitaciones.add(new HSimple(precio, max, camas));
        } else {
            System.out.print("Número de baños: ");
            int banios = Integer.parseInt(sc.nextLine());
            habitaciones.add(new HDoble(precio, max, banios));
        }
        System.out.println("Habitación creada.");
    }

    private void listarHabitaciones() {
        for (Habitacion h : habitaciones) System.out.println(h);
    }
    private void listarUsuarios() {
        for (Usuario u : usuarios) System.out.println(u);
    }
    private void listarReservas() {
        for (Reserva r : reservas) System.out.println(r);
    }

    /* --------- USER --------- */
    private void menuUser(Usuario user) {
        while (true) {
            System.out.println("\n--- MENU USER ("+user.getEmail()+") ---");
            System.out.println("1) Listar habitaciones disponibles");
            System.out.println("2) Hacer reserva");
            System.out.println("3) Mis reservas");
            System.out.println("4) Cancelar reserva");
            System.out.println("5) Logout");
            String op = sc.nextLine();
            switch (op) {
                case "1": listarHabitacionesDisponibles(); break;
                case "2": hacerReserva(user); break;
                case "3": listarMisReservas(user); break;
                case "4": cancelarReserva(user); break;
                case "5": return;
                default: System.out.println("Opción inválida");
            }
        }
    }

    private void listarHabitacionesDisponibles() {
        for (Habitacion h : habitaciones) {
            if (!h.isOcupada()) System.out.println(h);
        }
    }

    private void hacerReserva(Usuario user) {
        listarHabitacionesDisponibles();
        System.out.print("ID habitación: ");
        int id = Integer.parseInt(sc.nextLine());
        Habitacion h = buscarHabitacion(id);
        if (h == null || h.isOcupada()) {
            System.out.println("No disponible.");
            return;
        }
        System.out.print("Fecha entrada: ");
        String in = sc.nextLine();
        System.out.print("Fecha salida: ");
        String out = sc.nextLine();
        Reserva r = new Reserva(user, h, in, out);
        reservas.add(r);
        h.setOcupada(true);
        System.out.println("Reserva creada: " + r);
    }

    private Habitacion buscarHabitacion(int id) {
        for (Habitacion h : habitaciones) if (h.getId() == id) return h;
        return null;
    }

    private void listarMisReservas(Usuario user) {
        for (Reserva r : reservas) if (r.getUsuario().getId() == user.getId()) System.out.println(r);
    }

    private void cancelarReserva(Usuario user) {
        listarMisReservas(user);
        System.out.print("ID reserva: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Reserva r : reservas) {
            if (r.getId() == id && r.getUsuario().getId() == user.getId()) {
                r.cancelar();
                System.out.println("Reserva cancelada.");
                return;
            }
        }
        System.out.println("No encontrada.");
    }
}

