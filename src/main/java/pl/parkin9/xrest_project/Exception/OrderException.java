package pl.parkin9.xrest_project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class OrderException extends RuntimeException {

    public OrderException() {
        super("Error with sorting order");
    }

    public OrderException(String exception) {
        super(exception);
    }
}
