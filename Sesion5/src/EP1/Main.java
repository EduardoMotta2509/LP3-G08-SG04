package EP1;

public class Main {
	public static <F,S> void imprimirPar(Par<F,S> par) {
		System.out.println(par);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Par<String, Integer> par1 = new Par<>("Texto", 100);
		Par<String, Integer> par3 = new Par<>("Texto", 101);
        Par<Double, Boolean> par2 = new Par<>(3.14, par1.esIgual(par3));
        imprimirPar(par1);
        imprimirPar(par2);

        Contenedor<String, Integer> contenedor = new Contenedor<>();
        contenedor.agregarPar("Uno", 1);
        contenedor.agregarPar("Dos", 2);
        contenedor.agregarPar("Tres", 3);
        contenedor.mostrarPares();
	}

}
