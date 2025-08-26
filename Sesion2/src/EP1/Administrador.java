package EP1;

public class Administrador extends Individuo{
	private String contraseña;
	public static int identificador=1000;
	public static final int code=10000;
	public Administrador(String nombre, String contraseña) {
		super(code+identificador, nombre);
		this.contraseña = contraseña;
		identificador +=1;
	}
	
	@Override
	public void informacion() {
		System.out.println("Administrador: ");
		System.out.println("Nombres: "+nombre);
		System.out.println("Código: "+codigo);
	}
	
	public boolean login(String contra) {
		return contraseña.equals(contra);
	}
	
	public int getCodigo() {
		return codigo;
	}
}
