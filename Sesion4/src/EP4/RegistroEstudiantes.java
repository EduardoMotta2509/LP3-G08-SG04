package EP4;

import java.util.NoSuchElementException;

public class RegistroEstudiantes {
	private Estudiante[] estudiantes;
	private int cuenta;
	
	public RegistroEstudiantes() {
		estudiantes=new Estudiante[10];
		cuenta=0;
	}
	
	public void agregarEstudiante(Estudiante e1) throws IllegalArgumentException {
		if (e1.getNombre()==null || e1.getNombre().trim().isEmpty()) {
			throw new IllegalArgumentException("El estudiante no tiene nombre");
		}
		if (cuenta>=estudiantes.length) {
			throw new IllegalStateException("No hay espacio para más estudiantes");
		}
		estudiantes[cuenta]=e1;
		cuenta+=1;
	}
	
	public void buscarEstudiante(String nombre) throws NoSuchElementException{
		
		for (Estudiante i:estudiantes) {
			if (i !=null) {
				if (i.getNombre().equals(nombre)) {
					i.Informacion();
					
					return;
				}
			}
		}
		throw new NoSuchElementException("No se encontró al estudiante");
	}
	
}
