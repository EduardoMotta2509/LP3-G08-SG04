package Actividad1;

public abstract class Habitacion implements Imprimible {
    protected int numero;
    protected double precioPorNoche;
    protected String tipo;
    
    public Habitacion(int numero, double precioPorNoche, String tipo) {
        this.numero = numero;
        this.precioPorNoche = precioPorNoche;
        this.tipo = tipo;
    }
    
    public double getPrecio() {
        return precioPorNoche;
    }
    
    public abstract int getCapacidad();
    
    @Override
    public void descripcion() {
        System.out.println("Habitación " + tipo + " #" + numero);
        System.out.println("Precio por noche: " + precioPorNoche);
        System.out.println("Capacidad: " + getCapacidad() + " personas");
    }

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getPrecioPorNoche() {
		return precioPorNoche;
	}

	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    
    
}