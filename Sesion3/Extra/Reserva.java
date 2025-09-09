package Actividad1;

public class Reserva implements Imprimible {
    private int idReserva;
    private Cliente cliente;
    private Habitacion habitacion;
    private Fecha fechaInicio;
    private Fecha fechaFin;
    private boolean activa;
    private PoliticaCancelacion politicaCancelacion;
    
    public Reserva(int idReserva, Cliente cliente, Habitacion habitacion, Fecha fechaInicio, Fecha fechaFin, PoliticaCancelacion politicaCancelacion) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.activa = true;
        this.politicaCancelacion = politicaCancelacion;
    }

    public double calcularCosto() {
        int dias = (fechaFin.dia - fechaInicio.dia) + 1;
        return habitacion.getPrecio() * dias;
    }
    
    public boolean estaActiva() {
        return activa;
    }
    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    public Fecha getFechaInicio() {
        return fechaInicio;
    }
    public Fecha getFechaFin() {
        return fechaFin;
    }
    public Habitacion getHabitacion() {
        return habitacion;
    }
    public PoliticaCancelacion getPoliticaCancelacion() {
        return politicaCancelacion;
    }  
    public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
    public void descripcion() {
        System.out.println("Número de reserva: " + idReserva);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Habitación: " + habitacion.getNumero());
        System.out.println("Check-in: " + fechaInicio);
        System.out.println("Check-out: " + fechaFin);
        System.out.println("Estado: " + (activa ? "Activa" : "Cancelada"));
        System.out.println("Costo total: $" + calcularCosto());
    }
}