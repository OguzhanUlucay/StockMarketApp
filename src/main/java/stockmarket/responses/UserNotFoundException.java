package main.java.stockmarket.responses;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(Long userId) {
		super("Could not find specified user: " + userId);
	}
}
