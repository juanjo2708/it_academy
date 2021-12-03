package itacademy.barcelonactiva.cat.masterclass13.TDD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Ex02PasswordTest {

	private static Ex02Password ex02Password;

	@BeforeAll
	public static void init() {
		ex02Password = new Ex02Password();
		System.out.println("BeforeAll init() method called");

	}

	@BeforeEach
	public void initEach() {
		System.out.println("BeforeEach initEach() method called");
	}

	@Test
	void testPasswordCorrecte() {
		assertTrue(ex02Password.passwordCorrecte("Hola503300*"));
	}

	@Test
	void testPasswordNoCorrecte() {
		//assertFalse(ex02Password.passwordCorrecte("Ho3300*"));
		assertEquals(ex02Password.passwordCorrecte("Ho3300*"), false);
	}

	@AfterEach
	public void afterEach() {
		System.out.println("After Each");
	}

	@AfterAll
	public static void afterAll() {
		ex02Password = null;
		System.out.println("After ALL");
	}
	
	
}
