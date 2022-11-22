package link.ukrelay.federator.controllers;

import link.ukrelay.federator.exceptions.MissingSignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MissingSignatureExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(MissingSignatureException.class)
    public String handleException(MissingSignatureException ex) {
        return "Missing Signature";
    }

}
