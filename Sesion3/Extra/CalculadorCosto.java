package Actividad1;

public class CalculadorCosto {
    public double calcularCosto(Habitacion habitacion, Fecha inicio, Fecha fin) {
        int dias = calcularDias(inicio, fin);
        return habitacion.getPrecio() * dias;
    }
    
    public double calcularCostoConDescuento(Habitacion habitacion, Fecha inicio, Fecha fin, Promocion promocion) {
        double costoBase = calcularCosto(habitacion, inicio, fin);
        return promocion.calcularDescuento(costoBase);
    }
    
    private int calcularDias(Fecha inicio, Fecha fin) {
        // Implementar cálculo real de días
        return (fin.dia - inicio.dia) + 1;
    }
}