package br.com.abacomm.agilejava.chess.exception;

public class ConvertIndexException extends Exception {

	private static final long serialVersionUID = -8233076966259795066L;

	@Override
	public String getMessage() {
		return "Error to convert index: index dont are between a and h!";
	}
}
