package Controlador;

import Modelo.*;
import Vista.*;
import java.util.Scanner;

public class JugadorControlador {
    private Jugador jugador;
    private InventarioVista inventarioVista;
    private Scanner sc = new Scanner(System.in);

    public JugadorControlador(Jugador jugador, InventarioVista inventarioVista) {
        this.jugador = jugador;
        this.inventarioVista = inventarioVista;
    }

    public void verInventario() {
        inventarioVista.mostrarInventario(jugador.getInventario().obtenerItems());
        if (jugador.getArmaEquipada() != null) {
            System.out.println("Arma equipada: " + jugador.getArmaEquipada().getNombre());
        }
    }

    public void equiparArma() {
        verInventario();
        System.out.print("\nIngresa el nombre del arma que deseas equipar: ");
        String nombreArma = sc.next();

        Item item = jugador.getInventario().buscarItem(nombreArma);

        if (item != null && item.getTipo().equalsIgnoreCase("Arma")) {
            jugador.equiparArma(item);
        } else {
            inventarioVista.mostrarMensaje("No se encontró un arma con ese nombre.");
        }
    }

    public Jugador getJugador() {
        return jugador;
    }
}