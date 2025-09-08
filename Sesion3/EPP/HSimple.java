package EPP;

public class HSimple extends Habitacion {
    private int numeroCamas;
    public HSimple(double precio, int maxPersonas, int numeroCamas) {
        super(precio, maxPersonas);
        this.numeroCamas = numeroCamas;
    }
    @Override public String getTipo() { return "HSimple"; }
    @Override public String toString() {
        return super.toString() + ", camas=" + numeroCamas + "}";
    }
}

