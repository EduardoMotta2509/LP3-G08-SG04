package Strategy;

public class App {
	public static void main(String[] args) {
        NavegadorGPS gps = new NavegadorGPS(); //Creación del contexto

        System.out.println("--- Usuario selecciona modo AUTO ---");
        gps.setEstrategia(new RutaCarretera()); //Inyección de estrategia
        gps.ejecutarRuta("Plaza de Armas", "Aeropuerto");

        System.out.println("\n--- Usuario cambia a modo PEATONAL ---");
        gps.setEstrategia(new RutaPeatonal()); 
        gps.ejecutarRuta("Hotel", "Restaurante Turístico");
    }
}
