package EP1;

public class Docente extends Individuo{
	public static int identificador=1111;
	public Docente(int codigo, String nombre) {
		super(identificador, nombre);
		identificador +=1;
	}
	
	@Override
	public void informacion() {
		System.out.println("Docente: "+nombre);
		System.out.println("Código: "+codigo);
	}
	
	public String toString() {
		return "Docente"+nombre;
	}
}
