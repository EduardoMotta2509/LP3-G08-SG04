package StratCom;

public class EstrategiaEncender implements EstrategiaInterpretacion {
    @Override
    public boolean interpretar(String comando) {
        return comando.contains("enciende");
    }
}