package EP5;

import java.util.Scanner;

public class CargoEstacionamiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int opc=0;
		do {
			System.out.println("¿Qué desea hacer?");
			System.out.println("1. Calcular cargo por horas \n2. Salir");
			opc=scanner.nextInt();
			switch (opc) {
			case 1:
				System.out.println("Ingrese el número de horas: ");
				int horas=scanner.nextInt();
				if (horas<1) {
					System.out.println("Cobro no alcanzado, estacionamiento gratis.");
					break;
				}else {
					double cobro=3.0;
					horas -=1;
					cobro=cobro + (horas*0.5);
					if (cobro>12) {
						cobro=12;
					}
					System.out.println("Cargo: S/."+cobro);
				}
			}
		}while (opc!=2);
	}

}