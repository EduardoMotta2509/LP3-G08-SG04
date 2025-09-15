package EP4;

public class Estudiante {
	private String nombre;
	private int semestre;
	private double promedio;
	public Estudiante(String nombre, int semestre, double promedio) {
		super();
		this.nombre = nombre;
		this.semestre = semestre;
		this.promedio = promedio;
	}
	
	public void Informacion() {
		System.out.println("Nombre: "+nombre);
		System.out.println("Semestre: "+semestre+"°");
		System.out.println("Promedio: "+promedio);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
