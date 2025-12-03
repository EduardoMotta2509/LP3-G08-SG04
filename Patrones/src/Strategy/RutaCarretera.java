package Strategy;

class RutaCarretera implements EstrategiaRuta {
	public void construirRuta(String a, String b) {
		System.out.println("Calculando ruta para AUTO: Priorizando avenidas principales entre " + a + " y " + b);
	}
}