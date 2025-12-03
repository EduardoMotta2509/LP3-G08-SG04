package ACT2;

public class CalculadorPrecio {
    private PromocionStrategy strategy;
    public void setStrategy(PromocionStrategy strategy) {
        this.strategy = strategy;
    }
    public double calcular(double precioBase) {
        return strategy.calcularPrecio(precioBase);
    }
}