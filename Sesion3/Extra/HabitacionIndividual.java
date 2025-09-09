package Actividad1;

public class HabitacionIndividual extends Habitacion {
    public HabitacionIndividual(int numero, double precio) {
        super(numero, precio, "Individual");
    }
    
    @Override
    public int getCapacidad() {
        return 1;
    }
}
