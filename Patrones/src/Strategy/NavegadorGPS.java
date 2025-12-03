package Strategy;

class NavegadorGPS {
	private EstrategiaRuta estrategia;

	public void setEstrategia(EstrategiaRuta estrategia) {
		this.estrategia = estrategia;
	}

	public void ejecutarRuta(String a, String b) {
		estrategia.construirRuta(a, b);
	}
}