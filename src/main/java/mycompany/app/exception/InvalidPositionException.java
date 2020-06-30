package mycompany.app.exception;

public class InvalidPositionException extends RuntimeException {
    public InvalidPositionException(String errorMessage) {
        super(errorMessage);
    }
}
