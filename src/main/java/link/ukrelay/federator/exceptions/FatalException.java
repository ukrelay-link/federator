package link.ukrelay.federator.exceptions;

public class FatalException extends RuntimeException {
    public FatalException(final String message, final Throwable cause){
        super(message, cause);
    }
}
