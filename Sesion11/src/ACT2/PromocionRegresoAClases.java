package ACT2;

public class PromocionRegresoAClases implements PromocionStrategy {
    @Override
    public double calcularPrecio(double precioBase) {
        return precioBase * (1 - 0.35);
    }
}