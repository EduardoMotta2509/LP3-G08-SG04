package StratCom;

public class EstrategiaApagar implements EstrategiaInterpretacion {
    @Override
    public boolean interpretar(String comando) {
        return comando.contains("apaga");
    }
}
