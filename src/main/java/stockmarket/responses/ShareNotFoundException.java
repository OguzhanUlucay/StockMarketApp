package main.java.stockmarket.responses;

public class ShareNotFoundException extends RuntimeException {

	public ShareNotFoundException(String shareCode) {
		super("Could not find specified user: " + shareCode);
	}
}
