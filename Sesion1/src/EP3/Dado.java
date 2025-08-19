package EP3;

import java.util.Random;
public class Dado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random azar= new Random();
		int[] frecuencia = new int [6];
		
		for (int i=0; i<20000; i++) {
			int resultado= azar.nextInt(6)+1;
			frecuencia[resultado-1] +=1;
		}
		
		System.out.println("Resultados: \n");
		for (int i=0; i<6; i++) {
			System.out.println("Frecuencia de "+(i+1)+": "+frecuencia[i]);
		}
	}

}
