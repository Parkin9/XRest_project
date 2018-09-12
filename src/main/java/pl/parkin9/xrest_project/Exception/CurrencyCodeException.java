package pl.parkin9.xrest_project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CurrencyCodeException extends RuntimeException {

    public CurrencyCodeException(String exception) {
        super(exception);
    }
}
