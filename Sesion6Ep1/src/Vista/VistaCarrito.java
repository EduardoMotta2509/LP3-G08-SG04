package Vista;

import Modelo.Carrito;
import Modelo.Producto;

public class VistaCarrito {
	Carrito carrito;

	public VistaCarrito(Carrito carrito) {
		super();
		this.carrito = carrito;
	}
	
	public void verCarrito() {
		int iter=1;
		for (Producto i: carrito.getProductos()) {
			if (i!=null) {
				System.out.println(iter+". "+i);
				iter++;
			}
		}
	}
}
