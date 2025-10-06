package Modelo;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private InventarioModel inventario;
    private Item armaEquipada;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.salud = 100;
        this.nivel = 1;
        this.inventario = new InventarioModel();
    }

    public void equiparArma(Item arma) {
        if (arma != null && arma.getTipo().equals("Arma")) {
            armaEquipada = arma;
            System.out.println(nombre + " equipa el arma: " + arma.getNombre());
        }
    }

    public void atacar(Enemigo enemigo) {
        int dano;
        String armaUsada;

        if (armaEquipada != null) {
            dano= 100;
            armaUsada = armaEquipada.getNombre();
        } else {
            dano = 5;
            armaUsada = "sus puños";
        }
        dano=dano/enemigo.getNivel();
        enemigo.recibirDano(dano);
        System.out.println(nombre+" ataca a "+enemigo.getNombre() + " con " + armaUsada + " e inflige " + dano + " de daño.");
    }

    public void usarItem(String nombreItem) {
        Item item = inventario.buscarItem(nombreItem);
        if (item != null && item.getTipo().equalsIgnoreCase("Pocion")) {
            item.usarItem(this);
        } else {
            System.out.println("No se encontró una poción con ese nombre.");
        }
    }

    public void recibirDano(int dano) {
        salud -= dano;
        if (salud < 0) {
            salud = 0;
        }
    }

    public void recibirCura(int cura) {
        salud += cura;
        if (salud > 100) {
            salud = 100;
        }
    }

    public boolean estaVivo() {
        return salud > 0;
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

	public InventarioModel getInventario() {
		return inventario;
	}

	public void setInventario(InventarioModel inventario) {
		this.inventario = inventario;
	}

	public Item getArmaEquipada() {
		return armaEquipada;
	}

	public void setArmaEquipada(Item armaEquipada) {
		this.armaEquipada = armaEquipada;
	}
    
    
}
