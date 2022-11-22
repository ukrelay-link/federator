package link.ukrelay.federator.controllers;

import link.ukrelay.federator.exceptions.InvalidSignatureException;
import link.ukrelay.federator.exceptions.MissingSignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class InvalidSignatureExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidSignatureException.class)
    public String handleException(InvalidSignatureException ex) {
        log.error(ex.getMessage());
        return "Invalid Signature";
    }

}
