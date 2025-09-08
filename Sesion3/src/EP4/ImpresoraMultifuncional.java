package EP4;

public class ImpresoraMultifuncional implements Imprimible, Escaneable{
	@Override
	public void imprimir() {
		System.out.println("La impresora multifuncional puede imprimir");
	}
	@Override
	public void escanear() {
		System.out.println("La impresora multifuncional puede escanear");
	}

}
