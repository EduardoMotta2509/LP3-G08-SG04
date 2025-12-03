package EP2;

import java.util.List;

public class DescuentoPorcentual implements EstrategiaDescuento {
    @Override
    public double calcularPrecio(List<Producto> productos) {
        double total = productos.stream().mapToDouble(Producto::getPrecio).sum();
        boolean tieneDuplicados = productos.size() != productos.stream().distinct().count();
        return tieneDuplicados ? total * 0.70 : total;
    }
}