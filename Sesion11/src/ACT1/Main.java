package ACT1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Remitente remitente = new Remitente();
        Contacto contacto1 = new Contacto("Contacto1");
        Contacto contacto2 = new Contacto("Contacto2");
        remitente.addObserver(contacto1);
        remitente.addObserver(contacto2);
        remitente.notifyObservers("Hola?");

        remitente.blockObserver(contacto1);
        remitente.notifyObservers("Estoy bloqueado");
	}

}
