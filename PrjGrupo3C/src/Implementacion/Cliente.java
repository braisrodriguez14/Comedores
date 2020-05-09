package Implementacion;

public class Cliente {
    private String nombre;
    private String DNI;
    private String email;

    public Cliente(){

    }

    public Cliente(String nombre, String DNI, String email) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
