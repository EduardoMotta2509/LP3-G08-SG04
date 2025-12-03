package StratCom;

public class Alexa {
    private EstrategiaInterpretacion estrategia;
    private Command comando;

    public Alexa(EstrategiaInterpretacion estrategia, Command comando) {
        this.estrategia = estrategia;
        this.comando = comando;
    }

    public void procesarComando(String input) {
        if (estrategia.interpretar(input)) {
            comando.execute();
        } else {
            System.out.println("Comando no reconocido.");
        }
    }
}
