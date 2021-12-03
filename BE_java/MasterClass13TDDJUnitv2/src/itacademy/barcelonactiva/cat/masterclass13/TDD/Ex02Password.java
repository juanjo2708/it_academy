package itacademy.barcelonactiva.cat.masterclass13.TDD;

import javax.swing.JOptionPane;

public class Ex02Password {
	
	public static void main(String[] args) {

		String passw = JOptionPane.showInputDialog(null, "Password", "Petició de password",
				JOptionPane.QUESTION_MESSAGE);
		Ex02Password p = new Ex02Password();

		if (p.passwordCorrecte(passw)) {
			System.out.println("El password " + passw + " és correcte");
		} else {
			System.out.println("El password " + passw + " és INCORRECTE");
		}

	}

	public boolean passwordCorrecte(String password) {

		boolean result = false;

		if (password.length() > 10) {
			int numeros = 0;
			int lletres = 0;
			int altres = 0;
			for (int i = 0; i < password.length(); i++) {
				char c = password.charAt(i);

				if (isNumeric(c)) {
					numeros++;
				} else if (isLetter(c)) {
					lletres++;
				} else if (!isWhiteSpace(c)) {
					altres++;
				}

			}

			if (numeros >= 2 && lletres >= 2 && altres >= 1) {
				result = true;

			}
		}

		return result;

	}

	private boolean isLetter(char caract) {

		if (Character.isLetter(caract))
			return true;
		else
			return false;

	}

	private boolean isNumeric(char caract) {

		if (Character.isDigit(caract))
			return true;
		else
			return false;
	}

	private boolean isWhiteSpace(char caract) {

		if (Character.isWhitespace(caract))
			return true;
		else
			return false;
	}

}
