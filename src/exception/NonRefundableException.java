package src.exception;

public class NonRefundableException extends Exception {
    public NonRefundableException(String message) {
        super(message);
    }
}
