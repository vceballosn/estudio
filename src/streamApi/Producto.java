package streamApi;

public class Producto {
	
	String nombre;
    double precio;
    String categoria;

    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }
    
    public Producto(String nombre, String categoria) {
    	this.nombre =nombre;
    	this.categoria =categoria;
    }
    

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getCategoria() { return categoria; }
    
    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", precio=" + precio + ", categoria=" + categoria + "]";
    }
}
