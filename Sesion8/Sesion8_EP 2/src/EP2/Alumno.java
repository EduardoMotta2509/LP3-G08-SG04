package EP2;

public class Alumno {
    private String codigo;
    private String nombre;
    private double teorialp3;
    private double practicalp3;
    private double promedio;

    public Alumno(String codigo, String nombre, double teorialp3, double practicalp3, double promedio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.teorialp3 = teorialp3;
        this.practicalp3 = practicalp3;
        this.promedio = promedio;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getTeorialp3() { return teorialp3; }
    public double getPracticalp3() { return practicalp3; }
    public double getPromedio() { return promedio; }

    @Override
    public String toString() {
        return String.format("""
                Código: %s
                Nombre: %s
                Teoría: %.1f
                Práctica: %.1f
                Promedio: %.2f
                """, codigo, nombre, teorialp3, practicalp3, promedio);
    }
}
