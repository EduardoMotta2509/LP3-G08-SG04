package EP1;

public abstract class Individuo {
	protected int codigo;
	protected String nombre;
	
	public Individuo(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	public abstract void informacion();
			
}
