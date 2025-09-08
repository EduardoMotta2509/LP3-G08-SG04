package EP3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehiculo[] vehiculos=new Vehiculo[2];
		vehiculos[0]=new Bicicleta();
		vehiculos[1]=new Coche();
		for (Vehiculo i: vehiculos) {
			i.acelerar();
		}
	}

}
