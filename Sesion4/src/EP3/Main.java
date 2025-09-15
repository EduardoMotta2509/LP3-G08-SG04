package EP3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner (System.in);
		System.out.println("Valor por defecto: 0");
		
		Numero n=new Numero();
		n.setValor(0);
		
		int opc;
		
		do {
			System.out.println("1. Ver valor \n2. Establecer valor\n3. Salir");
			opc=sc.nextInt();
			switch (opc) {
			case 1:
				System.out.println(n.getValor());
				break;

			case 2:
				try {
				System.out.print("Ingrese valor: ");
				n.setValor(sc.nextDouble());
				}catch (IllegalArgumentException ilegal) {
					System.out.println("Ocurrió un error: "+ilegal.getMessage());
				}
				break;
			case 3:
				break;
			}
			
		}while (opc!=3);
	}

}
