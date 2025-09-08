package EP2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Forma[] formas=new Forma[4];
		formas[0]=new Circulo();
		formas[1]=new Cuadrado();
		formas[2]=new Rectangulo();
		formas[3]=new Triangulo();
		
		for (Forma i:formas) {
			i.dibujar();
		}
	}

}
