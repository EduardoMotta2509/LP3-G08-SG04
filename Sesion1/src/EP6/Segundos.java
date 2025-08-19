package EP6;

import java.util.Scanner;

public class Segundos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int horas, minutos, segundos;
		System.out.println("Ingrese el número de horas: ");
		horas=scanner.nextInt();
		System.out.println("Ingrese el número de minutos: ");
		minutos=scanner.nextInt();
		System.out.println("Ingrese el número de segundos: ");
		segundos=scanner.nextInt();
		
		System.out.println(horas+" horas con "+minutos+" minutos con "+segundos+" segundos \n");
		System.out.println("es igual a: "+equivalente(horas, minutos, segundos));
	}
	public static int equivalente(int horas,int minutos,int segundos) {
		int equivale=(horas*3600)+(minutos*60)+segundos;
		return equivale;
	}

}
