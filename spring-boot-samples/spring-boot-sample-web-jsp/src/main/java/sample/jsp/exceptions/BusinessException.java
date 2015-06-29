package sample.jsp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by thandomafela on 28/06/15.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        this(message, new Throwable());
    }

    public  BusinessException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
