package ACT2;

public class PromocionNavidad implements PromocionStrategy {
    @Override
    public double calcularPrecio(double precioBase) {
        return precioBase * (1 - 0.50); 
    }
}