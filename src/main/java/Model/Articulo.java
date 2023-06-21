package Model;

public class Articulo {
    private String nombreArticulo;
    private String tipoArticulo;
    private int peso;
    private int precio;

    public Articulo(String nombre, String tipoArticulo, int peso, int precio) {
        setNombreArticulo(nombre);
        setTipoArticulo(tipoArticulo);
        setPeso(peso);
        setPrecio(precio);
    }
    public Articulo(){

    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }
    private void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }
    public String getTipoArticulo() {
        return tipoArticulo;
    }
    private void setTipoArticulo(String tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }
    public int getPeso() {
        return peso;
    }
    private void setPeso(int peso) {
        this.peso = peso;
    }
    public int getPrecio() {
        return precio;
    }
    private void setPrecio(int precio) {
        this.precio = precio;
    }
}
