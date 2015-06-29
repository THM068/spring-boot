package sample.jsp.exceptions;

/**
 * Created by thandomafela on 28/06/15.
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        this(message, new Throwable());
    }

    public  BusinessException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
