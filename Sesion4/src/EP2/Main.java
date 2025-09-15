package EP2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculadora c1= new Calculadora();
		Scanner sc=new Scanner(System.in);
		
		double a, b;
		
		System.out.println("Ingrese 2 números para la calculadora: ");
		a=sc.nextDouble();
		b=sc.nextDouble();
		try {
			System.out.println("Suma: "+a+" + "+b+" = "+c1.suma(a, b));
			System.out.println("Resta: "+a+" - "+b+" = "+c1.resta(a, b));
			System.out.println("Multiplicacion: "+a+" * "+b+" = "+c1.multiplicacion(a, b));
			System.out.println("Suma: "+a+" / "+b+" = "+c1.division(a, b));
			
		}catch (DivisionPorCero dpc) {
			System.out.println("Ocurrió un error: "+dpc.getMessage());
			
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción IllegalArgument: " + e.getMessage());

        } catch (ArithmeticException e) {
            System.out.println("Excepción Aritmética: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Otra excepción: " + e.getMessage());
        }
	}

}
