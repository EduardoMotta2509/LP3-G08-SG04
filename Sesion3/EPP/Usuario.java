package EPP;

public class Usuario {
    private static int nextId = 1;
    private int id;
    private String email;
    private String password;
    private Rol rol;

    public Usuario(String email, String password, Rol rol) {
        this.id = nextId++;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public int getId() { return id; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Rol getRol() { return rol; }

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", email=" + email + ", rol=" + rol + "}";
    }
}

