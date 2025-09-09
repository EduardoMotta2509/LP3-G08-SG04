package Actividad1;

import java.util.ArrayList;
import java.util.List;

public class GestorDisponibilidad {
	private List<Reserva> reservasActivas;
    
    public GestorDisponibilidad() {
        this.reservasActivas = new ArrayList<>();
    }
    
    public boolean estaDisponible(Habitacion habitacion, Fecha inicio, Fecha fin) {
        for (Reserva reserva : reservasActivas) {
            if (reserva.getHabitacion().equals(habitacion) && 
                reserva.estaActiva() && 
                reservasSeSuperponen(reserva, inicio, fin)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean reservasSeSuperponen(Reserva reserva, Fecha inicio, Fecha fin) {
        return !(fin.antesQue(reserva.getFechaInicio()) || 
                 inicio.despuesQue(reserva.getFechaFin()));
    }
    
    public void agregarReserva(Reserva reserva) {
        reservasActivas.add(reserva);
    }
    
    public void eliminarReserva(Reserva reserva) {
        reservasActivas.remove(reserva);
    }
}
