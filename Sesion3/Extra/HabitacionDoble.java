package Actividad1;

public class HabitacionDoble extends Habitacion {
    public HabitacionDoble(int numero, double precio) {
        super(numero, precio, "Doble");
    }
    
    @Override
    public int getCapacidad() {
        return 2;
    }
}