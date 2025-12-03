package EP3;

public class GirarDerechaCommand implements Command {
    private Vehiculo vehiculo;
    public GirarDerechaCommand(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    @Override
    public void execute() {
        vehiculo.girarDerecha();
    }
}