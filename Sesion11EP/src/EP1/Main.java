package EP1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SistemaNotificaciones sistema = new SistemaNotificaciones();
        Usuario usuario1 = new Usuario("Juan");
        Usuario usuario2 = new Usuario("Ana");
        sistema.addObserver(usuario1);
        sistema.addObserver(usuario2);
        sistema.notifyObservers(new Notificacion("Nueva promoción disponible!"));
        sistema.removeObserver(usuario1);
        sistema.notifyObservers(new Notificacion("Actualización de producto."));
	}

}
