package ACT2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculadorPrecio calc = new CalculadorPrecio();
        double precioBase = 100.0;

        calc.setStrategy(new PromocionNavidad());
        System.out.println("Precio con Promoción Navidad: " + calc.calcular(precioBase));

        calc.setStrategy(new PromocionFiestasPatrias());
        System.out.println("Precio con Promoción Fiestas Patrias: " + calc.calcular(precioBase));

        calc.setStrategy(new PromocionRegresoAClases());
        System.out.println("Precio con Promoción Regreso a Clases: " + calc.calcular(precioBase));
	}

}
