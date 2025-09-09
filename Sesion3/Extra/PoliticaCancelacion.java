package Actividad1;

public interface PoliticaCancelacion {
    boolean puedeCancelar(Reserva reserva, Fecha fechaActual);
    double calcularPenalizacion(Reserva reserva);
}
