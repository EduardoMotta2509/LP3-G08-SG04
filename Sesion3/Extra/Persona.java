package Actividad1;

public abstract class Persona implements Imprimible {
    protected String nombre;
    protected int dni;
    
    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getDni() {
        return dni;
    }
}