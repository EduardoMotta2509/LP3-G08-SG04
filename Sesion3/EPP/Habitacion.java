package EPP;

public abstract class Habitacion {
    private static int nextId = 1;
    protected int id;
    protected double precio;
    protected int maxPersonas;
    protected boolean ocupada;

    public Habitacion(double precio, int maxPersonas) {
        this.id = nextId++;
        this.precio = precio;
        this.maxPersonas = maxPersonas;
        this.ocupada = false;
    }

    public int getId() { return id; }
    public boolean isOcupada() { return ocupada; }
    public void setOcupada(boolean o) { ocupada = o; }
    public abstract String getTipo();

    @Override
    public String toString() {
        return getTipo()+"{id="+id+", precio="+precio+", max="+maxPersonas+", ocupada="+ocupada+"}";
    }
}

