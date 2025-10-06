package Vista;
import Modelo.Enemigo;
import Modelo.Jugador;

public class CombateVista {
    public void mostrarEstadoCombate(Jugador jugador, Enemigo enemigo) {
        System.out.println("\nENTRASTE AL COMBATE!");
        System.out.println("Jugador: " + jugador.getNombre() + " | Salud: " + jugador.getSalud());
        System.out.println("Enemigo: " + enemigo.getNombre() + " | Salud: " + enemigo.getSalud());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}