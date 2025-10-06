package Modelo;

import java.util.ArrayList;
import java.util.Date;

public class Compra {
	private Date fecha;
    private ArrayList<Producto> productos;
    private double total;
    
	public Compra(ArrayList<Producto> productos, double total) {
		super();
		this.fecha = new Date();
		this.productos = productos;
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "Monto: "+total+" - Fecha: "+fecha;
	}
	
	public void detalle() {
		System.out.println("Monto: "+total+" - Fecha: "+fecha);
		for (Producto i:productos) {
			if (i!=null) {
				System.out.println(i);
			}
		}
	}
    
}
