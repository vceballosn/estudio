package estudio;

public class Sobrecarga {

	public static void main(String[] args ) {
		
		// Invocamos el método max con parametros int
		 System.out.println("El maximo entre 3 y 4 es: "
		 + max(3, 4));
	// Invocamos el método max con parametros double
		 System.out.println("El maximo entre 3.0 y 5.4 es: "
		 + max(3.0, 5.4));
	// Invocamos el método max con 3 parametros int
		 System.out.println("El maximo entre 3.0, 5.4 y 10.14 es: "
		 + max(3.0, 5.4, 10.14));
		
		
	}
	
	public static int max(int num1, int num2){
		if (num1 > num2)
		return num1;
		else
		return num2;
		}
		 
		public static double max(double num1, double num2){
		if (num1 > num2)
		return num1;
		else
		return num2;
		}
		 
		public static double max(double num1, double num2, double num3){
		return max(max(num1, num2), num3);
		}

}
