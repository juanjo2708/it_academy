package cat.academy.it.S52_F2_2.exceptions;

import java.time.LocalDateTime;

//import com.fasterxml.jackson.annotation.JsonFormat;

public class ExceptionResponse {

// --- PROPIETATS DE LA CLASSE -------------------------------------------------------	
	private String errorMessage;
	private String errorCode;
	
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	
	
// --- GETTERS, SETTERS, TOSTRING ----------------------
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [errorMessage=" + errorMessage + ", errorCode=" + errorCode + ", timestamp="
				+ timestamp + "]";
	}
	
	
	
}
