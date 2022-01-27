package cat.academy.it.S52_F2_2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
		
	public ResourceNotFoundException (String missatge) {
		super(missatge);
	}
	
	public ResourceNotFoundException(String missatge, Throwable causa) {
		super(missatge, causa);
	}

}
