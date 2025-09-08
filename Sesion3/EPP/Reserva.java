package EPP;

public class Reserva {
    private static int nextId = 1;
    private int id;
    private Usuario usuario;
    private Habitacion habitacion;
    private String fechaIn;
    private String fechaOut;
    private boolean cancelada;

    public Reserva(Usuario u, Habitacion h, String in, String out) {
        this.id = nextId++;
        this.usuario = u;
        this.habitacion = h;
        this.fechaIn = in;
        this.fechaOut = out;
        this.cancelada = false;
    }

    public int getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public Habitacion getHabitacion() { return habitacion; }
    public void cancelar() { this.cancelada = true; habitacion.setOcupada(false); }

    @Override
    public String toString() {
        return "Reserva{id="+id+", user="+usuario.getEmail()+", hab="+habitacion.getId()+
                ", in="+fechaIn+", out="+fechaOut+", cancelada="+cancelada+"}";
    }
}
