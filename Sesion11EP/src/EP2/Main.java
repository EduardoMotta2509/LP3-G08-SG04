package EP2;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        CalculadoraDePrecios calc = new CalculadoraDePrecios();
        List<Producto> productos = List.of(
            new Producto("Producto1", 50.0),
            new Producto("Producto1", 50.0),
            new Producto("Producto2", 30.0),
            new Producto("Producto3", 20.0)
        );
        System.out.println("Elige estrategia:");
        System.out.println("1. Sin Descuento");
        System.out.println("2. Descuento Fijo (10%)");
        System.out.println("3. Descuento Porcentual (30% si 2 iguales)");
        System.out.println("4. Descuento Porcentual Acumulado (50% en el más bajo si 3+)");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1 -> calc.setEstrategia(new SinDescuento());
            case 2 -> calc.setEstrategia(new DescuentoFijo());
            case 3 -> calc.setEstrategia(new DescuentoPorcentual());
            case 4 -> calc.setEstrategia(new DescuentoPorcentualAcumulado());
            default -> {
                System.out.println("Opción inválida");
                return;
            }
        }
        double precioFinal = calc.calcular(productos);
        System.out.println("Precio final: " + precioFinal);

	}

}
