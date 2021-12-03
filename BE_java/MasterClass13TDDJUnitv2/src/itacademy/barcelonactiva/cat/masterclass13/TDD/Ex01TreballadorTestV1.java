package itacademy.barcelonactiva.cat.masterclass13.TDD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Ex01TreballadorTestV1 {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeAll");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("AfterAll");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("BeforeEach");

	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("AfterEach");
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Mereix plus salarial")
	public void mereixPlusSalarial()
	{
		fail("Not yet implemented");
	}

	
	@Test
	@DisplayName("NO Mereix plus salarial")
	public void noMereixPlusSalarial()
	{
		fail("Not yet implemented");
	}


}
