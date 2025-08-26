package EP1;

public class Alumno extends Individuo {
	protected int creditos;
	protected Curso[] cursosMatriculados;
	public static int identificador=1010;
	public static final int code=20240000;
	protected int totalC=0;
	
	public Alumno(String nombre) {
		super(code+identificador,nombre);
		this.creditos = 23;
		identificador +=1;
		this.cursosMatriculados=new Curso[7];
	}
	
	public void matricular(Curso curso) {
	    for (int i = 0; i < totalC; i++) {
	        if (cursosMatriculados[i].equals(curso)) {
	            System.out.println("Ya está matriculado en el curso: " + curso.getNombre());
	            return; 
	        }
	    }
		if (totalC<cursosMatriculados.length) {
			if (curso.matricular(this)) {
				creditos -= curso.getValor();
				cursosMatriculados[totalC]=curso;
				totalC++;			
			}
		}else {
			System.out.println("Alcanzó el límite de cursos permitidos. ");
		}
	}
	
	@Override
	public void informacion() {
		System.out.println("Alumno: "+nombre);
		System.out.println("Código: "+codigo);
		System.out.println("Créditos disponibles: "+creditos);
		System.out.println("Cursos matriculados: ");
		for (int i=0; i<totalC; i++) {
			System.out.print(cursosMatriculados[i]+" - ");
		}
		System.out.println("");
	}
	
	public String toString() {
		return "Alumno "+nombre;
	}

	public int getCodigo() {
		return codigo;
	}
	
	
	
}
