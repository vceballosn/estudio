package com.estudio;

import java.util.Calendar;

public class DriveDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creamos un primero objeto calendar
		Calendar futureCal = Calendar.getInstance();
		 
		// Lo ponemos en el año 2020 para que sea futura a la actual
		futureCal.set(Calendar.YEAR, 2020);
 
		// Creamos un segundo objeto calendar
		Calendar now = Calendar.getInstance();
 
		System.out.println("Fecha actual : " + (now.get(Calendar.MONTH) )
						+ "-"
						+ now.get(Calendar.DATE)
						+ "-"
						+ now.get(Calendar.YEAR));
		
		System.out.println(" Fecha now " + now);
 
		System.out.println("Es una fecha futura a la actual ? : " + futureCal.after(now));

	}

}
