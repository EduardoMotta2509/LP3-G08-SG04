package Actividad1;

public class GestorReservas {
    private Notificador notificador;
    private GestorDisponibilidad gestorDisponibilidad;
    private int contadorReservas;
    
    public GestorReservas(Notificador notificador, GestorDisponibilidad gestorDisponibilidad) {
        this.notificador = notificador;
        this.gestorDisponibilidad = gestorDisponibilidad;
        this.contadorReservas = 1;
    }
    
    public Reserva crearReserva(Cliente cliente, Habitacion habitacion, Fecha inicio, Fecha fin, PoliticaCancelacion politica) {
        if (gestorDisponibilidad.estaDisponible(habitacion, inicio, fin)) {
            Reserva reserva = new Reserva(contadorReservas++, cliente, habitacion, inicio, fin, politica);
            gestorDisponibilidad.agregarReserva(reserva);
            cliente.agregarReserva(reserva);
            String mensaje = "Reserva #" + reserva.getIdReserva() + " confirmada. " + "Habitación: " + habitacion.getNumero() + " del " + inicio + " al " + fin;
            notificador.enviarNotificacion(mensaje, cliente.getTelefono());
            
            return reserva;
        }
        return null;
    }
    
    public boolean cancelarReserva(Reserva reserva, Fecha fechaActual) {
        if (reserva.estaActiva() && reserva.getPoliticaCancelacion().puedeCancelar(reserva, fechaActual)) {
            reserva.setActiva(false);
            gestorDisponibilidad.eliminarReserva(reserva);
            
            String mensaje = "Reserva #" + reserva.getIdReserva() + " cancelada. " +"Penalización: $" + reserva.getPoliticaCancelacion().calcularPenalizacion(reserva);
            notificador.enviarNotificacion(mensaje, reserva.getCliente().getTelefono());
            
            return true;
        }
        return false;
    }
}