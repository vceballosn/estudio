package com.estudio.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.estudio.Estudio;
import junit.framework.TestCase;

@DisplayName("Aserciones soportadas")
public class EstudioTest extends TestCase {
	@Test
	public void sumaTest() {
		assertEquals(8, Estudio.suma(3, 5));
	}

	@Test
	public void cadenaTest() {
		StringBuilder cadenaEsperada = new StringBuilder();
		cadenaEsperada.append("p=2/nombreBanco:bancolombia/agencia:centro");
		assertEquals(cadenaEsperada.toString(), Estudio.cadena());
	}
}
