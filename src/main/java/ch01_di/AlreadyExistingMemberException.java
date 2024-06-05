package ch01_di;

public class AlreadyExistingMemberException extends RuntimeException{
	public AlreadyExistingMemberException(String message) {
		super(message);
	}
}
