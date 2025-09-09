package Actividad1;

import java.util.ArrayList;
import java.util.List;

public class PersonalLimpieza extends Personal {
    private List<Habitacion> habitacionesAsignadas;

    public PersonalLimpieza(String nombre, int dni, int idPersonal) {
        super(nombre, dni, idPersonal);
        this.habitacionesAsignadas = new ArrayList<>();
    }
    
    public void asignarHabitacion(Habitacion habitacion) {
        habitacionesAsignadas.add(habitacion);
    }
    
    public void removerHabitacion(Habitacion habitacion) {
        habitacionesAsignadas.remove(habitacion);
    }
    
    public void mostrarAsignaciones() {
        System.out.println("Habitaciones asignadas - Personal: " + nombre);
        for (Habitacion h : habitacionesAsignadas) {
            System.out.println("Habitación: " + h.getNumero() + " - " + h.getTipo());
        }
    }
    
    @Override
    public void descripcion() {
        System.out.println("PERSONAL DE LIMPIEZA");
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + idPersonal);
        System.out.println("DNI: " + dni);
        System.out.println("Habitaciones asignadas: " + habitacionesAsignadas.size());
    }
}