package Actividad1;

public class PoliticaCancelacionEstricta implements PoliticaCancelacion {
    @Override
    public boolean puedeCancelar(Reserva reserva, Fecha fechaActual) {
        // Lógica para política estricta
        return false; // Implementar lógica real
    }
    
    @Override
    public double calcularPenalizacion(Reserva reserva) {
        return reserva.calcularCosto(); // Penalización total
    }
}