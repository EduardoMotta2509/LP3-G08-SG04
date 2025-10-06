package Modelo;

public class Item {
	private String nombre;
	private int cantidad;
	private String tipo;
	private String Descripcion;
		
	public Item(String nombre, int cantidad, String tipo, String descripcion) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.tipo = tipo;
		Descripcion = descripcion;
	}

	public void usarItem() {
		if (cantidad>0) {
			System.out.println("Usaste tu "+nombre);
			cantidad--;
			System.out.println("Te quedan "+cantidad);
		}else {
			System.out.println("No puedes usarlo, te quedaste sin el objeto");
		}
	}
	
    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - Cantidad: " + cantidad;
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
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
    
    
}
