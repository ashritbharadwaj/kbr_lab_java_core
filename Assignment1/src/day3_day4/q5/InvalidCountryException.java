package day3_day4.q5;

public class InvalidCountryException extends Exception {
    public InvalidCountryException() {
        super();
    }

    public InvalidCountryException(String message) {
        super(message);
    }

    public InvalidCountryException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCountryException(Throwable cause) {
        super(cause);
    }
}

