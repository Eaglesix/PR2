package exceptions.account;

public class BankException extends Exception {

	public BankException() {
		super();
	}
	
	public BankException(String message) {
		super(message);
	}
	
	public BankException(Throwable cause)
	{
		super(cause);
	}
}
