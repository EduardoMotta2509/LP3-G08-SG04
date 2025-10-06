package Modelo;

public class Item {
    private String nombre;
    private int cantidad;
    private String tipo;
    private String descripcion;

    public Item(String nombre, int cantidad, String tipo, String descripcion){
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public void usarItem(Jugador jugador) {
        if (tipo.equalsIgnoreCase("Pocion")) {
            jugador.recibirCura(20);
            cantidad--;
            System.out.println(jugador.getNombre()+" usa "+nombre+" y recupera salud.");
        }
    }

    @Override
    public String toString() {
        return nombre+" (" + tipo + ") x"+cantidad;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


    
}
