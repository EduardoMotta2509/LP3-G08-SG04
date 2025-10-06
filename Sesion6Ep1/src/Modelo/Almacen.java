package Modelo;

import java.util.ArrayList;

public class Almacen {
	private ArrayList<Producto> almacen;
	
	public Almacen() {
		almacen=new ArrayList<>();
	}
	
    public void agregarProducto(Producto p) {
        almacen.add(p);
    }

    public void eliminarProducto(int index) {
        almacen.remove(index-1);
    }

	public ArrayList<Producto> getAlmacen() {
		return almacen;
	}

	public void setAlmacen(ArrayList<Producto> almacen) {
		this.almacen = almacen;
	}
    
    
}
