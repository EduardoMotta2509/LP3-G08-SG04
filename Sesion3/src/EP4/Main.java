package EP4;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Impresora impresora=new Impresora();
		ImpresoraMultifuncional impresoraM=new ImpresoraMultifuncional();
		
		impresora.imprimir();
		
		impresoraM.imprimir();
		impresoraM.escanear();
	}

}
