package itacademy.barcelonactiva.cat.masterclass13.TDD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

class Ex01TreballadorTestV2 {

	@Test
	public void MerecePlusSalarial() {
		Ex01Treballador t = new Ex01Treballador("Anna", "Saurina", 45, 30000);
		assertTrue(t.plus(1000) == true);
	}

	@Test
	public void NoMerecePlusSalarial() {
		Ex01Treballador t = new Ex01Treballador("Anna", "Saurina", 35, 30000);
		assertFalse(t.plus(1000) == true);
		// assertTrue(t.plus(1000) == false);
	}

	@Test
	public void treballadorIgual() {
		Ex01Treballador t1 = new Ex01Treballador("Anna", "Saurina", 65, 333000);
		// Ex01Treballador t2 = new Ex01Treballador("Anna2", "Saurina2", 25, 30300);
		Ex01Treballador t2 = t1;

		assertEquals(t1, t2);
		// assertEquals(t1.equals(t2), true);

	}

	// Formes de deshabilitar un test:
	@Test
	// @Disabled Deshabilitació total
	// @DisabledOnOs(OS.MAC) //Deshabilitació quan executem en un MAC
	// @DisabledOnJre(JRE.JAVA_9) //Deshabilitació per una JRE concreta
	// @DisabledIf("#{systemProperties['java.version'].startsWith('1.7')}")
	// //Condicions del SO o variables d'entorn

	public void test01() {
		assertTrue(true);
	}

}
