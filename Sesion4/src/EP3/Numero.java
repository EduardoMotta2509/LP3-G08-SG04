package EP3;

public class Numero {
	public double valor;

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) throws IllegalArgumentException {
		if (valor<0) {
			throw new IllegalArgumentException("NÚMERO NO PUEDE SER NEGATIVO");
		}
		this.valor = valor;
	}
}
