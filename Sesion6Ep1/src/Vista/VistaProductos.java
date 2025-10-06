package Vista;

import Modelo.Almacen;
import Modelo.Producto;

public class VistaProductos {
	Almacen almacen;

	public VistaProductos(Almacen almacen) {
		super();
		this.almacen = almacen;
	}
	
	public void verAlmacen() {
		int iter=1;
		for (Producto i: almacen.getAlmacen()) {
			if (i!=null) {
				System.out.println(iter+". "+i);
				iter++;
			}
		}
	}
}
