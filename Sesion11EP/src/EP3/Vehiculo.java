package EP3;

public class Vehiculo {
    private int velocidad = 0;
    private String direccion = "Recto";
    public void acelerar() {
        velocidad += 10;
        System.out.println("Acelerando. Velocidad: " + velocidad);
    }
    public void frenar() {
        if (velocidad > 0) {
            velocidad -= 10;
        }
        System.out.println("Frenando. Velocidad: " + velocidad);
    }
    public void girarIzquierda() {
        direccion = "Izquierda";
        System.out.println("Girando volante a la izquierda. Dirección: " + direccion);
    }
    public void girarDerecha() {
        direccion = "Derecha";
        System.out.println("Girando volante a la derecha. Dirección: " + direccion);
    }
    public void bocina() {
        System.out.println("PIP PIP");
    }
}