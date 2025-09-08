package EP1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalcularPago c1= new CalcularPago();
		InformeEmpleado IP= new InformeEmpleado();
		Empleado e1= new Empleado("Leandro",2000,"Desarrollo");
		Empleado e2= new Empleado("Eduardo", 3000,"Infraestructura");
		
		IP.generarInforme(c1, e1);
		IP.generarInforme(c1, e2);
	}

}
