package org.spring.template.webapp.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.template.core.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

/**
 * Created by osman on 9.5.2017.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="IOException occured")
    @ExceptionHandler(IOException.class)
    public void handleIOException(){
        logger.error("IOException handler executed");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<CustomException> handleException(MethodArgumentNotValidException exception) {
        CustomException validationException = new CustomException(1,1,exception.getMessage());
        logger.info("Validation exception ocurrs");
        return new ResponseEntity<CustomException>(validationException, HttpStatus.BAD_REQUEST);
    }

}
