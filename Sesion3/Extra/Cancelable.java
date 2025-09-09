package Actividad1;

public interface Cancelable {
    boolean puedeCancelar(Reserva reserva);
    void cancelarReserva(Reserva reserva);
}