package br.com.brian.exception.handler;

import br.com.brian.exception.ExcptionReponse;
import br.com.brian.exception.UnsuportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExcptionReponse> handleAllExceptions(Exception ex, WebRequest request){
        ExcptionReponse exceptionResponse = new ExcptionReponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsuportedMathOperationException.class)
    public final ResponseEntity<ExcptionReponse> handleBadRequestExceptions(Exception ex, WebRequest request){
        ExcptionReponse exceptionResponse = new ExcptionReponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
