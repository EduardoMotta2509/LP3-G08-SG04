package Actividad1;

public class PoliticaCancelacionFlexible implements PoliticaCancelacion {
    @Override
    public boolean puedeCancelar(Reserva reserva, Fecha fechaActual) {
        // Lógica para política flexible
        return true; // Implementar lógica real
    }
    
    @Override
    public double calcularPenalizacion(Reserva reserva) {
        return 0; // Sin penalización
    }
}