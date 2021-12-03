package itacademy.barcelonactiva.cat.masterclass13.TDD;

public class Ex03Calculadora {

	public Ex03Calculadora(int val1, int val2) {
		this.val1 = val1;
		this.val2 = val2;
	}

	public int sumar() {
		return this.val1 + this.val2;
	}

	public int restar() {
		return this.val1 - this.val2;
	}

	public int multiplicar() {
		return this.val1 * this.val2;
	}

	public int dividir() {

		//return this.val1 / this.val2;
		
		int result = 0;
		try {
			result = this.val1 / this.val2;

		} catch (ArithmeticException ex) {
			System.out.println("divisio per zero");

		}
		return result;
	}

	private int val1;
	private int val2;

}
