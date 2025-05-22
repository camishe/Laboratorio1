package paqueteprincipal;

public class Clientes {
    private String nombre;
    private String apellido;
    private long cedulaIdentidad;
    private long telefono;

    public Clientes(String nombre, String apellido, long cedulaIdentidad, long telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedulaIdentidad = cedulaIdentidad;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getCedulaIdentidad() {
        return cedulaIdentidad;
    }

    public void setCedulaIdentidad(long cedulaIdentidad) {
        this.cedulaIdentidad = cedulaIdentidad;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
}
