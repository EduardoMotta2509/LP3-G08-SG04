package Actividad1;

public class HabitacionSuite extends Habitacion {
    public HabitacionSuite(int numero, double precio) {
        super(numero, precio, "Suite");
    }
    
    @Override
    public int getCapacidad() {
        return 4;
    }
    
    @Override
    public void descripcion() {
        super.descripcion();
        System.out.println("Incluye servicios premium");
    }
}