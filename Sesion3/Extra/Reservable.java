package Actividad1;

public interface Reservable {
    boolean puedeReservar(Cliente cliente, Fecha inicio, Fecha fin);
    Reserva crearReserva(Cliente cliente, Fecha inicio, Fecha fin);
}
