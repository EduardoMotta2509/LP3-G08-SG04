package EP1;

public class InformeEmpleado {
	public void generarInforme(CalcularPago c, Empleado empleado) {
		System.out.println("Empleado: "+empleado.getNombre());
		System.out.println("Departamento: "+empleado.getDepartamento());
		System.out.println("Sueldo base: "+empleado.getSalario());
		System.out.println("Pago calculado: "+c.calcularPago(empleado));
	}
}
