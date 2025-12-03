package ACT3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Televisor tv = new Televisor();
        ControlRemoto control = new ControlRemoto();
        control.setComando(0, new EncenderCommand(tv));
        control.setComando(1, new ApagarCommand(tv));
        control.setComando(2, new SubirVolumenCommand(tv));
        control.setComando(3, new BajarVolumenCommand(tv));
        control.setComando(4, new CambiarCanalCommand(tv, 5));
        control.presionarBoton(0); 
        control.presionarBoton(2); 
        control.presionarBoton(2); 
        control.presionarBoton(4); 
        control.presionarBoton(1);
	}

}
