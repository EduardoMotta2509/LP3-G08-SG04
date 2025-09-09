package Actividad1;

public class Main {
    public static void main(String[] args) {
        Notificador notificador = new NotificadorEmail();
        GestorDisponibilidad gestorDisponibilidad = new GestorDisponibilidad();
        GestorReservas gestorReservas = new GestorReservas(notificador, gestorDisponibilidad);
        
        HabitacionIndividual habitacion101 = new HabitacionIndividual(101, 15);
        HabitacionDoble habitacion201 = new HabitacionDoble(201, 25);
        HabitacionSuite habitacion301 = new HabitacionSuite(301, 50);
        
        Cliente cliente = new Cliente("Juan Pérez", 12345678, "juan@email.com");

        PoliticaCancelacion politicaFlexible = new PoliticaCancelacionFlexible();
        PoliticaCancelacion politicaEstricta = new PoliticaCancelacionEstricta();

        Fecha hoy = new Fecha(15, 6, 2024);
        Fecha manana = new Fecha(16, 6, 2024);
        Fecha pasadoManana = new Fecha(17, 6, 2024);
        
        Reserva reserva = gestorReservas.crearReserva(cliente, habitacion101, hoy, manana, politicaFlexible);

        habitacion101.descripcion();    

        cliente.descripcion();

        PersonalLimpieza personal = new PersonalLimpieza("María García", 87654321, 1001);
        personal.asignarHabitacion(habitacion101);
        personal.asignarHabitacion(habitacion201);
        
        personal.mostrarAsignaciones();
        
        boolean cancelada = gestorReservas.cancelarReserva(reserva, hoy);
        System.out.println("Reserva cancelada: " + (cancelada ? "Sí" : "No"));
    }
}