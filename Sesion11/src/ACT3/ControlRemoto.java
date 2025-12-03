package ACT3;

public class ControlRemoto {
    private Command[] comandos = new Command[5];
    public void setComando(int slot, Command comando) {
        comandos[slot] = comando;
    }
    public void presionarBoton(int slot) {
        if (comandos[slot] != null) {
            comandos[slot].execute();
        }
    }
}