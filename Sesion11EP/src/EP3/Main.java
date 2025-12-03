package EP3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Vehiculo vehiculo = new Vehiculo();
        
        ControlVehiculo control = new ControlVehiculo();
        control.setComando(0, new AcelerarCommand(vehiculo));
        control.setComando(1, new FrenarCommand(vehiculo));
        control.setComando(2, new GirarIzquierdaCommand(vehiculo));
        control.setComando(3, new GirarDerechaCommand(vehiculo));
        control.setComando(4, new BocinaCommand(vehiculo));
        
        control.presionarBoton(0);
        control.presionarBoton(2);
        control.presionarBoton(2);
        control.presionarBoton(3);
        control.presionarBoton(4);
        control.presionarBoton(1);

	}

}
