package ACT3;

public class Televisor {
    private boolean encendido = false;
    private int volumen = 10;
    private int canal = 1;
    public void encender() {
        encendido = true;
        System.out.println("TV encendida");
    }
    public void apagar() {
        encendido = false;
        System.out.println("TV apagada");
    }
    public void subirVolumen() {
        if (encendido) {
            volumen++;
            System.out.println("Volumen: " + volumen);
        }
    }
    public void bajarVolumen() {
        if (encendido) {
            volumen--;
            System.out.println("Volumen: " + volumen);
        }
    }
    public void cambiarCanal(int nuevoCanal) {
        if (encendido) {
            canal = nuevoCanal;
            System.out.println("Canal: " + canal);
        }
    }
}
