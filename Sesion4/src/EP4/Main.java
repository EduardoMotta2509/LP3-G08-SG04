package EP4;

import java.util.NoSuchElementException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegistroEstudiantes registro = new RegistroEstudiantes();

        try {
            registro.agregarEstudiante(new Estudiante("Leandro", 2, 18.11));
            registro.agregarEstudiante(new Estudiante("Eduardo", 4, 18.10));
            registro.agregarEstudiante(new Estudiante("Luis", 1, 12.0));
            registro.agregarEstudiante(new Estudiante("   ",3,17.75));

        } catch (IllegalArgumentException e) {
            System.out.println("Error al agregar: "+e.getMessage());
        } catch (IllegalStateException e) {
        	System.out.println("Error al agregar: "+e.getMessage());
        }

        try {
            registro.buscarEstudiante("Leandro");

        } catch (NoSuchElementException e) {
            System.out.println("Ups... Hubo un error: " + e.getMessage());
        }
	}

}
