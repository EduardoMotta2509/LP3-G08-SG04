package EP2;

import java.util.Scanner;

public class ArregloOrdenado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner= new Scanner (System.in);
		int[] arreglo= new int[10];
		int num;
		
		System.out.println("Ingrese número: ");
		arreglo[0]= scanner.nextInt();
		
		for (int i=1; i<10; i++) {
			System.out.println("Ingrese número: ");
			num=scanner.nextInt();
			if (num<=arreglo[i-1]) {
				System.out.println("El número debe ser mayor al anterior: "+arreglo[i-1]);
				i-=1;
			}else {
				arreglo[i]=num;
			}
		}
		for (int i=0; i<10; i++) {
			System.out.println(arreglo[i]+" ");
		}
	}

}
