package Actividad1;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private String telefono;
    private List<Reserva> historialReservas;
    
    public Cliente(String nombre, int dni, String telefono) {
        super(nombre, dni);
        this.telefono = telefono;
        this.historialReservas = new ArrayList<>();
    }

    public void agregarReserva(Reserva reserva) {
        historialReservas.add(reserva);
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void consultarHistorial() {
        System.out.println("Historial de reservas cliente " + this);
        for (Reserva r : historialReservas) {
            r.descripcion();
            System.out.println("-----------------------------");
        }
    }
    
    @Override
    public void descripcion() {
        System.out.println("CLIENTE");
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Contacto: " + telefono);
        System.out.println("Total reservas: " + historialReservas.size());
    }
    
    public String toString() {
        return nombre + " (DNI: " + dni + ")";
    }
}