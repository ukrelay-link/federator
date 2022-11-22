package link.ukrelay.federator.controllers;

import link.ukrelay.federator.exceptions.MissingActorException;
import link.ukrelay.federator.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MissingActorExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingActorException.class)
    public String handleException(MissingActorException ex) {
        return "Actor not provided";
    }

}
