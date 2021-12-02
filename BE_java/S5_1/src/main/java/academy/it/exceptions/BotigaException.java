package academy.it.exceptions;

public class BotigaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public BotigaException(String missatge) {
		super(missatge);
	}

}
