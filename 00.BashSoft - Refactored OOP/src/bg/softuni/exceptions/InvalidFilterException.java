package bg.softuni.exceptions;

public class InvalidFilterException extends RuntimeException{

    private static final String INVALID_FILTER = "Invalid filter.";

    public InvalidFilterException() {
        super(INVALID_FILTER);
    }

    public InvalidFilterException(String message) {
        super(message);
    }
}