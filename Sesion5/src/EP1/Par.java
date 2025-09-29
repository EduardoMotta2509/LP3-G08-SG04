package EP1;

public class Par <F,S>{
	private F primero;
	private S segundo;
	
	public Par(F primero, S segundo){
		this.primero = primero;
		this.segundo = segundo;
	}

	public F getPrimero() {
		return primero;
	}

	public void setPrimero(F primero) {
		this.primero = primero;
	}

	public S getSegundo() {
		return segundo;
	}

	public void setSegundo(S segundo) {
		this.segundo = segundo;
	}
	
	public String toString() {
		return "Primero: "+primero+"  Segundo: "+segundo;
	}
	
	public boolean esIgual(Par<F,S> p2) {
		if (primero.equals(p2.getPrimero()) && segundo.equals(p2.getSegundo())) {
			return true;
		}else {
			return false;
		}
	}
}
