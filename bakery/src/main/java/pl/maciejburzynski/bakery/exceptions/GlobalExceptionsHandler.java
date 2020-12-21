package pl.maciejburzynski.bakery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ResponseBody
    @ExceptionHandler(BreadNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String BreadNotFoundExceptionHandler(BreadNotFoundException exception){
        return exception.getMessage();
    }


    @ResponseBody
    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CustomerNotFoundExceptionHandler(CustomerNotFoundException exception){
        return exception.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String UserNotFoundExceptionHandler(UserNotFoundException exception){
        return exception.getMessage();
    }
}
