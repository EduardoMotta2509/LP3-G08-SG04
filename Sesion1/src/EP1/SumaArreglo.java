package EP1;

import java.util.Scanner;

public class SumaArreglo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int[] arreglo= {1,3,5,7,9};
		System.out.println(sumar(arreglo));
		
	}
	
	public static int sumar(int[] arreglo) {
		int suma=0;
		for (int n: arreglo) {
			suma += n;
		}
		return suma;
	}

}
