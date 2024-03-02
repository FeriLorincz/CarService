package exceptions;

public class InvalidCarException extends RuntimeException {

    public InvalidCarException(String message) {
        super(message);
    }
}
