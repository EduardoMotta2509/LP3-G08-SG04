package Modelo;


public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public void recibirDano(int dano) {
        salud -= dano;
        if (salud < 0) {
            salud = 0;
        }
    }
    
    public boolean estaVivo() {
    	return salud>0;
    }

    public void atacar(Jugador jugador) {
        int dano = 10*nivel;
        jugador.recibirDano(dano);
        System.out.println(nombre+" ataca a "+jugador.getNombre()+" e inflige "+dano+" de daño.");
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    
}