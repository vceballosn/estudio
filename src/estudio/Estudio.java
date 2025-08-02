package estudio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Estudio {
	
	public static void main (String args[]){
		
List<Integer> numeros = new ArrayList<Integer>(Arrays.asList(2, 3, 4,3)); // llenado de lista java 9 lo nuevo

List<Integer> numeros2 = new ArrayList<>();


Stream<Integer> st = numeros.stream();

//llenado de lista version 1.8
	/*	numeros.add(2);
		numeros.add(3);
		numeros.add(4);
		numeros.add(3);*/	
//https://www.arquitecturajava.com/trabajando-con-java-8-intstream/
// prueba stream mejoras de java 1.8 corriendo en java 10 
		
		System.out.println(" Cuantas veces se repite el numero 3 en la lista  "+ st.filter(Predicate.isEqual(3)).count() +"veces");
		
		
		
		
		//numeros.stream().filter((x)-> x>=3).forEach((n) -> System.out.println("numeros mayores que  cinco "+n));
		//numeros.stream().filter((x)-> x>=3);
		   numeros.stream().forEach(System.out::println);
		
	    
		
		numeros.forEach((n) -> System.out.println("numeros "+n));
		
		
		
		// pruebas de lambda en java 1.8 corriendo en java 10
		Operador suma = (x,y) -> x+y;
		Operador resta = (x,y)-> x-y;
		
		System.out.println(suma.operador(4, 5));
		System.out.println(resta.operador(4, 5));
		System.out.println(20&13);
		int x =0;
		do {
			
			System.out.println(x);
			x++;
			
		}while (x<10);
	}

}
