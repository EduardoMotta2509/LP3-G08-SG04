package Actividad1;

public class Promocion implements Imprimible {
    private String nombre;
    private int porcentajeDescuento;
    private Fecha fechaInicio;
    private Fecha fechaFin;
    
    public Promocion(String nombre, int porcentajeDescuento, Fecha fechaInicio, Fecha fechaFin) {
        this.nombre = nombre;
        this.porcentajeDescuento = porcentajeDescuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    public boolean aplica(Reserva reserva) {
        return fechaInicio.antesQue(reserva.getFechaInicio()) && 
               fechaFin.despuesQue(reserva.getFechaFin());
    }
    
    public double calcularDescuento(double precio) {
        return precio - (precio * porcentajeDescuento / 100);
    }
    
    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }
    
    @Override
    public void descripcion() {
        System.out.println("PROMOCIÓN: " + nombre);
        System.out.println("Descuento: " + porcentajeDescuento + "%");
        System.out.println("Válida del " + fechaInicio + " al " + fechaFin);
    }
}