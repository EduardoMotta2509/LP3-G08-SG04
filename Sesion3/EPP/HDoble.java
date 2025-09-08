package EPP;
public class HDoble extends Habitacion {
    private int numBanios;
    public HDoble(double precio, int maxPersonas, int numBanios) {
        super(precio, maxPersonas);
        this.numBanios = numBanios;
    }
    @Override public String getTipo() { return "HDoble"; }
    @Override public String toString() {
        return super.toString() + ", banios=" + numBanios + "}";
    }
}
