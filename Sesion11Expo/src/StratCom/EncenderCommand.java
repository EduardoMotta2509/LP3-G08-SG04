package StratCom;

public class EncenderCommand implements Command {
    private Luz luz;

    public EncenderCommand(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void execute() {
        luz.encender();
    }
}
