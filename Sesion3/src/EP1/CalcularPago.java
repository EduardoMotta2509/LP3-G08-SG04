package EP1;

public class CalcularPago {
	private final int porcentajeAFP=12;
	public double calcularPago(Empleado empleado) {
		return empleado.getSalario()-(empleado.getSalario()*porcentajeAFP/100);
	}
}
