package itacademy.barcelonactiva.cat.masterclass13.TDD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Ex03CalculadoraTest {

	@Test
	@DisplayName("Comprovar suma dos números positius")
	public void comprovaSumaPositius() {
		int resultado = new Ex03Calculadora(10, 15).sumar();
		// assertTrue(resultado == 25);
		assertEquals(resultado, 25);

	}

	@Test
	@DisplayName("Comprovar resta dos números positius")
	public void comprovaRestaPositius() {
		int resultado = new Ex03Calculadora(10, 15).restar();
		assertTrue(resultado == -5);

	}

	@Test
	@DisplayName("Comprovar multiplicació dos números positius")
	public void comprovaMultipicacioPositius() {
		int resultado = new Ex03Calculadora(10, 15).multiplicar();
		assertTrue(resultado == 150);
	}

	@Test
	@DisplayName("Comprovar divisió dos números positius")
	public void comprovaDivisioPositius() {
		int resultado = new Ex03Calculadora(10, 15).dividir();
		assertTrue(resultado == 0);

	}

	@Test
	@DisplayName("Comprovar divisió per cero esperant excepció")
	public void comprovaDivisioPerZero() {
		assertThrows(ArithmeticException.class, () -> {
			new Ex03Calculadora(10, 0).dividir();
		});
	}

	@Test
	@DisplayName("Comprovar divisió per cero sense esperar excepció")
	public void comprovaDivisioPerZeroSenseComprovarExcepcio() {
		int resultado = new Ex03Calculadora(10, 0).dividir();
		assertTrue(resultado == 0);

	}

	@Test
	@DisplayName("Comprobar división de números negativos")
	public void comprovaDivisioNumerosNegatius() {
		fail("No implementada");
	}
	

}
