package paqueteprincipal;

public class Reservas {
    private int numDias;
    private Clientes cliente;

    public Reservas(int numDias, Clientes cliente) {
        this.numDias = numDias;
        this.cliente = cliente;
    }

    public int getNumDias() {
        return numDias;
    }

    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    // Devuelve el nombre completo del cliente
    public String getNombreCompletoCliente() {
        return cliente.getNombre() + " " + cliente.getApellido();
    }
}
