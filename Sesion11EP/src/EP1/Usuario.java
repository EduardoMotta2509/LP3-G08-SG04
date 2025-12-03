package EP1;

public class Usuario implements Observer {
    private String nombre;
    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void update(Notificacion notificacion) {
        System.out.println(nombre + " recibió notificación: " + notificacion.getMensaje());
    }
    public String getNombre() {
        return nombre;
    }
}