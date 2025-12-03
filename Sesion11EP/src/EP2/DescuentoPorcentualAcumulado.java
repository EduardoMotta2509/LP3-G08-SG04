package EP2;

import java.util.List;

public class DescuentoPorcentualAcumulado implements EstrategiaDescuento {
    @Override
    public double calcularPrecio(List<Producto> productos) {
        if (productos.size() >= 3) {
            double minPrecio = productos.stream().mapToDouble(Producto::getPrecio).min().orElse(0);
            double total = productos.stream().mapToDouble(Producto::getPrecio).sum();
            return total - (minPrecio * 0.50);
        }
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }
}