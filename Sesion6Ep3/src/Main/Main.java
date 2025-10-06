package Main;

import Modelo.*;
import Vista.*;
import Controlador.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Jugador jugador = new Jugador("Aventurero");
        jugador.getInventario().agregarItem(new Item("Espada", 1, "Arma", "Espada de acero"));
        jugador.getInventario().agregarItem(new Item("Arco", 1, "Arma", "Arco de madera"));
        jugador.getInventario().agregarItem(new Item("Pocion", 2, "Pocion", "Restaura salud"));
        jugador.equiparArma(jugador.getInventario().buscarItem("Espada"));

        List<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(new Enemigo("Duende", 500, 4, "Bestia"));
        enemigos.add(new Enemigo("Pekka", 100, 10, "Guerrero"));

        InventarioVista inventarioVista = new InventarioVista();
        CombateVista combateVista = new CombateVista();

        JugadorControlador jugadorControlador = new JugadorControlador(jugador, inventarioVista);
        CombateModelo combateModelo = new CombateModelo(jugador, enemigos);
        CombateControlador combateControlador = new CombateControlador(combateModelo, combateVista);

        int opcion;
        do {
            System.out.println("\nBIENVENIDO AL JUEGO");
            System.out.println("1. Ver inventario");
            System.out.println("2. Equipar arma");
            System.out.println("3. Entrar en combate");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    jugadorControlador.verInventario();
                    break;
                case 2:
                    jugadorControlador.equiparArma();
                    break;
                case 3:
                    combateControlador.iniciarCombate();
                    break;
                case 0:
                    System.out.println("Saliendo del juego...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        } while (opcion != 0);
    }
}