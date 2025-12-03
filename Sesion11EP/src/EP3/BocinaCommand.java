package EP3;

public class BocinaCommand implements Command {
    private Vehiculo vehiculo;
    public BocinaCommand(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    @Override
    public void execute() {
        vehiculo.bocina();
    }
}
