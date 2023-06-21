package Model;

public class Cliente {
    private String nombreCliente;
    private int rut;
    private String correo;

    public Cliente(String nombreCliente, int rut, String correo) {
        setNombreCliente(nombreCliente);
        setRut(rut);
        setCorreo(correo);
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    private void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    public int getRut() {
        return rut;
    }
    private void setRut(int rut) {
        this.rut = rut;
    }
    public String getCorreo() {
        return correo;
    }
    private void setCorreo(String correo) {
        this.correo = correo;
    }
}
