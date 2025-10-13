package EP2;

import java.util.Scanner;

public class Main {

	   public static void main(String[] args) {
		   // TODO Auto-generated method stub
	        Gestor gestor = new Gestor("personajes.txt");
	        Scanner sc = new Scanner(System.in);
	        int opcion;

	        do {
	            System.out.println("\nPersonajes de videojuego");
	            System.out.println("1. Mostrar personajes");
	            System.out.println("2. Agregar personaje");
	            System.out.println("3. Modificar personaje");
	            System.out.println("4. Eliminar personaje");
	            System.out.println("5. Filtrar por atributo");
	            System.out.println("6. Mostrar estadísticas");
	            System.out.println("7. Actualizar atributo individual");
	            System.out.println("8. Importar personajes desde archivo");
	            System.out.println("9. Subir nivel a un personaje");
	            System.out.println("10. Salir");
	            System.out.print("Seleccione una opción: ");
	            opcion = sc.nextInt();
	            sc.nextLine();

	            switch (opcion) {
	            case 1 -> gestor.mostrar();

	            case 2 -> {
	                System.out.print("Nombre: ");
	                String nombre = sc.nextLine().trim();
	                while (nombre.isEmpty() || nombre.length() > 10) {
	                    System.out.println("El nombre debe tener entre 1 y 10 caracteres.");
	                    nombre = sc.nextLine().trim();
	                }

	                System.out.print("Vida: ");
	                int vida = sc.nextInt();
	                while (vida <= 0 || vida > 99) {
	                    System.out.println("La vida no puede ser negativa, 0 o mayor a 99");
	                    vida = sc.nextInt();
	                }

	                System.out.print("Ataque: ");
	                int ataque = sc.nextInt();
	                while (ataque <= 0 || ataque > 99) {
	                    System.out.println("El ataque no puede ser negativo, 0 o mayor a 99");
	                    ataque = sc.nextInt();
	                }

	                System.out.print("Defensa: ");
	                int defensa = sc.nextInt();
	                while (defensa <= 0 || defensa > 99) {
	                    System.out.println("La defensa no puede ser negativa, 0 o mayor a 99");
	                    defensa = sc.nextInt();
	                }

	                System.out.print("Alcance: ");
	                int alcance = sc.nextInt();
	                while (alcance <= 0 || alcance > 99) {
	                    System.out.println("El alcance no puede ser negativo, 0 o mayor a 99");
	                    alcance = sc.nextInt();
	                }

	                sc.nextLine();
	                gestor.agregar(new Personaje(nombre, vida, ataque, defensa, alcance));
	            }

	            case 3 -> {
	                System.out.print("Nombre a modificar: ");
	                String nombre = sc.nextLine();

	                System.out.print("Nueva vida: ");
	                int vida = sc.nextInt();
	                while (vida <= 0 || vida > 99) {
	                    System.out.println("La vida no puede ser negativa, 0 o mayor a 99");
	                    vida = sc.nextInt();
	                }

	                System.out.print("Nuevo ataque: ");
	                int ataque = sc.nextInt();
	                while (ataque <= 0 || ataque > 99) {
	                    System.out.println("El ataque no puede ser negativo, 0 o mayor a 99");
	                    ataque = sc.nextInt();
	                }

	                System.out.print("Nueva defensa: ");
	                int defensa = sc.nextInt();
	                while (defensa <= 0 || defensa > 99) {
	                    System.out.println("La defensa no puede ser negativa, 0 o mayor a 99");
	                    defensa = sc.nextInt();
	                }

	                System.out.print("Nuevo alcance: ");
	                int alcance = sc.nextInt();
	                while (alcance <= 0 || alcance > 99) {
	                    System.out.println("El alcance no puede ser negativo, 0 o mayor a 99");
	                    alcance = sc.nextInt();
	                }

	                sc.nextLine();
	                gestor.modificar(nombre, vida, ataque, defensa, alcance);
	            }

	            case 4 -> {
	                System.out.print("Nombre a eliminar: ");
	                String nombre = sc.nextLine();
	                gestor.eliminar(nombre);
	            }

                case 5 -> {
                    System.out.print("Atributo para ordenar (vida, ataque, defensa, alcance): ");
                    String atributo = sc.nextLine().trim().toLowerCase();
                    new Funcionalidades(gestor).filtrarPorAtributo(atributo);
                }

                case 6 -> new Funcionalidades(gestor).mostrarEstadisticas();

                case 7 -> {
                    System.out.print("Nombre del personaje: ");
                    String nombre = sc.nextLine().trim();
                    System.out.print("Atributo a actualizar (vida, ataque, defensa, alcance): ");
                    String atributo = sc.nextLine().trim().toLowerCase();
                    System.out.print("Nuevo valor (1–99): ");
                    int nuevo = sc.nextInt();
                    new Funcionalidades(gestor).actualizarAtributo(nombre, atributo, nuevo);
                }

                case 8 -> {
                    System.out.print("Ruta del archivo a importar: ");
                    String ruta = sc.nextLine().trim();
                    new Funcionalidades(gestor).importar(ruta);
                }

                case 9 -> {
                    System.out.print("Nombre del personaje: ");
                    String nombre = sc.nextLine().trim();
                    System.out.print("Cantidad de niveles a subir: ");
                    int niveles = sc.nextInt();
                    new Funcionalidades(gestor).subirNivel(nombre, niveles);
                }

                case 10 -> System.out.println("Vuelve pronto!");

                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 10);
        sc.close();
    }
}
