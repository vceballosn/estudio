package streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiExample {
	
	  public static void main(String[] args) {
	        List<Producto> productos = Arrays.asList(
	            new Producto("Laptop", 1200.00, "Electronica"),
	            new Producto("Teclado", 45.50, "Electronica"),
	            new Producto("Mouse", 25.00, "Electronica"),
	            new Producto("Monitor", 300.00, "Electronica")
	        );

	        List<String> nombresProductosCaros = productos.stream() // 1. Obtener el stream de la lista
	            .filter(producto -> producto.getPrecio() < 50.00) // 2. Operación intermedia: filtrar
	            .map(Producto::getNombre) // 3. Operación intermedia: mapear a nombres
	            .collect(Collectors.toList()); // 4. Operación terminal: recolectar en una nueva lista

	        System.out.println(nombresProductosCaros); // Salida: [Laptop, Monitor]
	    }

}
