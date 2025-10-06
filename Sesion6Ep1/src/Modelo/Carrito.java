package Modelo;

import java.util.ArrayList;

public class Carrito {
	private ArrayList<Producto> productos;
	
	public Carrito() {
		 productos = new ArrayList<>();
	}
	
    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void eliminarProducto(int index) {
        productos.remove(index-1);
    }
    
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    public void eliminar() {
    	productos.clear();
    }
}
