package Controlador;

import Modelo.*;
import Vista.CombateVista;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CombateControlador {
    private CombateModelo modelo;
    private CombateVista vista;
    private Scanner sc = new Scanner(System.in);
    private Random rand = new Random();

    public CombateControlador(CombateModelo modelo, CombateVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarCombate() {
        Jugador jugador = modelo.getJugador();
        List<Enemigo> enemigos = modelo.getEnemigos();

        Enemigo enemigo = modelo.obtenerEnemigoAleatorio();
        vista.mostrarMensaje("\nUn " + enemigo.getNombre() + " aparece!");

        while (!modelo.combateTerminado()) {
            vista.mostrarEstadoCombate(jugador, enemigo);
            System.out.println("\n1. Atacar");
            System.out.println("2. Usar pocion");
            System.out.println("3. Huir");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    jugador.atacar(enemigo);
                    break;
                case 2:
                    System.out.print("Nombre de la pocion: ");
                    String nombrePocion = sc.next();
                    jugador.usarItem(nombrePocion);
                    break;
                case 3:
                    vista.mostrarMensaje("Has huido del combate.");
                    return;
                default:
                    vista.mostrarMensaje("Opcion invalida.");
                    break;
            }

            if (!enemigo.estaVivo()) {
                vista.mostrarMensaje("Has derrotado a " + enemigo.getNombre() + ".");
                break;
            }

            if (jugador.estaVivo()) {
                enemigo.atacar(jugador);
            }
        }

        if (!jugador.estaVivo()) {
            vista.mostrarMensaje(jugador.getNombre() + " ha sido derrotado.");
        } else {
            vista.mostrarMensaje("Victoria!");
        }
    }
}