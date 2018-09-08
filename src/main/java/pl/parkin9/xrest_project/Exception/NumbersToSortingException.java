package pl.parkin9.xrest_project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NumbersToSortingException extends RuntimeException {

    public NumbersToSortingException() {
        super("Data to sorting - not found.");
    }

    public NumbersToSortingException(String exception) {
        super(exception);
    }
}
