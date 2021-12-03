package itacademy.barcelonactiva.cat.masterclass13.TDD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Ex03CalculadoraTest {

	@Test
	@DisplayName("Comprovar suma dos n�meros positius")
	public void comprovaSumaPositius() {
		int resultado = new Ex03Calculadora(10, 15).sumar();
		// assertTrue(resultado == 25);
		assertEquals(resultado, 25);

	}

	@Test
	@DisplayName("Comprovar resta dos n�meros positius")
	public void comprovaRestaPositius() {
		int resultado = new Ex03Calculadora(10, 15).restar();
		assertTrue(resultado == -5);

	}

	@Test
	@DisplayName("Comprovar multiplicaci� dos n�meros positius")
	public void comprovaMultipicacioPositius() {
		int resultado = new Ex03Calculadora(10, 15).multiplicar();
		assertTrue(resultado == 150);
	}

	@Test
	@DisplayName("Comprovar divisi� dos n�meros positius")
	public void comprovaDivisioPositius() {
		int resultado = new Ex03Calculadora(10, 15).dividir();
		assertTrue(resultado == 0);

	}

	@Test
	@DisplayName("Comprovar divisi� per cero esperant excepci�")
	public void comprovaDivisioPerZero() {
		assertThrows(ArithmeticException.class, () -> {
			new Ex03Calculadora(10, 0).dividir();
		});
	}

	@Test
	@DisplayName("Comprovar divisi� per cero sense esperar excepci�")
	public void comprovaDivisioPerZeroSenseComprovarExcepcio() {
		int resultado = new Ex03Calculadora(10, 0).dividir();
		assertTrue(resultado == 0);

	}

	@Test
	@DisplayName("Comprobar divisi�n de n�meros negativos")
	public void comprovaDivisioNumerosNegatius() {
		fail("No implementada");
	}
	

}
