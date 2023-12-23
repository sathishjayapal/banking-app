package me.sathish.loans.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LoanExistsException extends RuntimeException {
    public LoanExistsException(String message) {
        super(message);
    }
}
