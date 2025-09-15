package EP2;

public class Calculadora {
	public double suma (double a, double b) {
		return a+b;
	}
	
	public double resta (double a, double b) {
		return a-b;
	}
	
	public double multiplicacion(double a, double b) {
		return a*b;
	}
	
	public double division(double a, double b) throws DivisionPorCero{
	if (b==0) {
		throw new DivisionPorCero("Está intentando dividir por cero, no es posible");
	}
	return a/b;
	}
}
