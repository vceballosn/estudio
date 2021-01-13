package com.estudio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.interfaces.Operador;

public class Estudio {
	
	public static int   suma(int a, int b) {
		Operador suma = (x,y) -> x+y;
		return suma.operador(a, b);
	}
	
	public static String cadena() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("p=2/nombreBanco:bancolombia/agencia:centro");
		return cadena.toString();
	}
	
	
	public static void main (String args[]){
		
List<Integer> numeros = new ArrayList<Integer>(Arrays.asList(2, 3, 4,3,3,3)); // llenado de lista java 9 lo nuevo
Stream st = numeros.stream();

//llenado de lista version 1.8
	/*	numeros.add(2);
		numeros.add(3);
		numeros.add(4);
		numeros.add(3);*/	
// prueba stream mejoras de java 1.8 corriendo en java 10 
		
		System.out.println(" Cuantas veces se repite el numero 3 en la lista  "+ st.filter(Predicate.isEqual(3)).count() +"veces");
		
		// pruebas de lambda en java 1.8 corriendo en java 10
		Operador suma = (x,y) -> x+y;
		Operador resta = (x,y)-> x-y;
		Operador multiplicacion = (x,y) -> x*y;
		Operador division = (x,y) -> x/y;
		Operador resto  =(x,y) -> x%y;
		
		System.out.println(" Suma: "+suma.operador(4, 5));
		System.out.println(" Resta: "+resta.operador(4, 5));
		System.out.println(" Multiplicacion: "+multiplicacion.operador(4,5));
		System.out.println(" Division: "+division.operador(5,6));
		System.out.println(" Resto %: "+resto.operador(10,3));
		System.out.println(" test Suma: " + suma(4,2));
	}

}
