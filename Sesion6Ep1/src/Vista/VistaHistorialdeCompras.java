package Vista;
import Modelo.HistorialCompras;
import Modelo.Compra;
public class VistaHistorialdeCompras {
	private HistorialCompras historial;

	public VistaHistorialdeCompras(HistorialCompras historial) {
		super();
		this.historial = historial;
	}
	
	public void verHistorial() {
		int it=1;
		for (Compra i:historial.getHistorialCompras()) {
			if (i!=null) {
				System.out.println(it+". "+i);
				it++;
			}
		}
	}
	
	public void detalleCompra(int index) {
		if (index<0 || index>historial.getHistorialCompras().size()) {
			System.out.println("No está en el rango");
			return;
		}
		
		historial.getHistorialCompras().get(index).detalle();
	}
}
