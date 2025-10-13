package EP1;

public class Personaje {
	private String nombre;
	private int vida, ataque, defensa, alcance;
	public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
		super();
		if (vida <= 0 || ataque <= 0 || defensa <= 0 || alcance <= 0) {
            throw new IllegalArgumentException("Atributos deben ser mayores a 0.");
        }
		this.nombre = nombre;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.alcance = alcance;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		if (vida<=0 || vida>99) {
			throw new IllegalArgumentException("La vida debe ser mayor a 0 y menor a 100");
		}
		this.vida = vida;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int araque) {
		if (araque<=0 || araque>99) {
			throw new IllegalArgumentException("El ataque debe ser mayor a 0 y menor a 100");
		}
		this.ataque = araque;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		if (defensa<=0 || defensa>99) {
			throw new IllegalArgumentException("La defensa debe ser mayor a 0 y menor a 100");
		}
		this.defensa = defensa;
	}
	public int getAlcance() {
		return alcance;
	}
	public void setAlcance(int alcance) {
		if (alcance<=0 || alcance>99) {
			throw new IllegalArgumentException("El alcance debe ser mayor a 0 y menor a 100");
		}
		this.alcance = alcance;
	}
	
    @Override
    public String toString() {
        return nombre + ": Vida=" + vida + ", Ataque=" + ataque + ", Defensa=" + defensa + ", Alcance=" + alcance;
    }
    
    private final int longitudn=10;
    private final int longituda=7;
    public String toFileLine() {
        return String.format(
            "%-" + longitudn + "s%-"
            + longituda + "d%-"
            + longituda + "d%-"
            + longituda + "d%-"
            + longituda + "d",
            nombre, vida, ataque, defensa, alcance
        );
    }
}
