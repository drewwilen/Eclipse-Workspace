package ErrorsExceptions;

public class UnderAge extends Exception {
	String message;

	public UnderAge(String message) {
		this.message = message;
	}

	public String toString() {
		return super.toString() + " - " + message + "\nCause: " + getCause();
	}
}
