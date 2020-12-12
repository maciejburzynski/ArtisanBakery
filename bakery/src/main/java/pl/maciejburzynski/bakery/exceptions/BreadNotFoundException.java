package pl.maciejburzynski.bakery.exceptions;

public class BreadNotFoundException extends RuntimeException {

    public BreadNotFoundException(String message) {
        super(message);
    }

    public BreadNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
