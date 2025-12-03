package ACT2;

public class PromocionFiestasPatrias implements PromocionStrategy {
    @Override
    public double calcularPrecio(double precioBase) {
        return precioBase * (1 - 0.28); 
    }
}