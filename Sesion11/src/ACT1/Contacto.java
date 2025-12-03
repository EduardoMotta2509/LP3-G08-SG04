package ACT1;

public class Contacto implements Observer {
    private String name;
    public Contacto(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name + " recibió: " + message);
    }
}