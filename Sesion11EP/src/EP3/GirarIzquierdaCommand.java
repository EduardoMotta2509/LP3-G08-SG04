package EP3;

public class GirarIzquierdaCommand implements Command {
    private Vehiculo vehiculo;
    public GirarIzquierdaCommand(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    @Override
    public void execute() {
        vehiculo.girarIzquierda();
    }
}