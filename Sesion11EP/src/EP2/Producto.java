package EP2;

public class Producto {
    private String nombre;
    private double precio;
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public double getPrecio() {
        return precio;
    }
    public String getNombre() {
        return nombre;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return nombre.equals(producto.nombre);
    }
    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
