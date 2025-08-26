package EP1;

public class Curso {
	private String nombre;
	private Docente docente;
	private int valor;
	private int cupos;
	private int matriculados;
	private Alumno[] estudiantes; 
	private String categoria;
	private String aula;
	
	public Curso(String nombre, Docente docente, int valor, int cupos, String categoria, String aula) {
		super();
		this.nombre = nombre;
		this.docente = docente;
		this.valor= valor;
		this.cupos = cupos;
		this.estudiantes = new Alumno[cupos];
		this.categoria = categoria;
		this.aula = aula;
		matriculados=0;
	}	
	
	public boolean matricular(Alumno alumno) {
		if (matriculados<cupos) {
			if (alumno.creditos>=valor) {
				estudiantes[matriculados] = alumno;
				matriculados++;
				return true;
			}else {
				System.out.println("No hay créditos suficientes");
				return false;
			}
		}else {
			System.out.println("No hay cupos disponibles, seleccione otra clase");
			return false;
		}
	}
	
	public void info() {
		System.out.println("Curso: "+nombre);
		System.out.println("Categoría: "+categoria);
		System.out.println("Créditos: "+valor);
		System.out.println("Docente a cargo: "+docente);
		System.out.println("Cupos: "+matriculados+"/"+cupos);
		System.out.println("Aula: "+aula);
	}
	
	public void lista() {
		System.out.println("Lista de matriculados: "+matriculados+"/"+cupos);
		int j=1;
		for (Alumno i:estudiantes) {
			System.out.println(j+". "+i);
			j++;
		}
	}
	
	public String toString() {
		return nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object curso2) {
		Curso c2=(Curso) curso2;
		return this.nombre.equals(c2.getNombre());
	}
	
}
