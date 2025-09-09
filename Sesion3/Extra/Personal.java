package Actividad1;

public abstract class Personal extends Persona {
    protected int idPersonal;

    public Personal(String nombre, int dni, int idPersonal) {
        super(nombre, dni);
        this.idPersonal = idPersonal;
    }
    
    public int getIdPersonal() {
        return idPersonal;
    }
}