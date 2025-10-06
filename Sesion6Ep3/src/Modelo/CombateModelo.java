package Modelo;

import java.util.List;
import java.util.Random;

public class CombateModelo {
    private Jugador jugador;
    private List<Enemigo> enemigos;

    public CombateModelo(Jugador jugador, List<Enemigo> enemigos) {
        this.jugador = jugador;
        this.enemigos = enemigos;
    }

    public Jugador getJugador() { return jugador; }
    public List<Enemigo> getEnemigos() { return enemigos; }

    public boolean combateTerminado() {
        boolean jugadorMuerto = !jugador.estaVivo();
        boolean enemigosVivos = false;

        for (Enemigo e : enemigos) {
            if (e.estaVivo()) {
                enemigosVivos = true;
                break;
            }
        }

        return jugadorMuerto || !enemigosVivos;
    }

    public Enemigo obtenerEnemigoAleatorio() {
        Random r = new Random();
        return enemigos.get(r.nextInt(enemigos.size()));
    }
}