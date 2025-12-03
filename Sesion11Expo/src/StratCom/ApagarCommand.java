package StratCom;

public class ApagarCommand implements Command {
    private Luz luz;

    public ApagarCommand(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void execute() {
        luz.apagar();
    }
}
