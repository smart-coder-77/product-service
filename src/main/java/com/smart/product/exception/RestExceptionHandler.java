package com.smart.product.exception;

import com.smart.product.entity.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Choudhury Subham on 31-05-2022
 */

@RestController
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleProductNotFoundException(){
        ErrorDetails errorDetails= new ErrorDetails(404,"No product available in DB",new Date());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ProductIdNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleProductIdNotFoundException(){
        ErrorDetails errorDetails= new ErrorDetails(404,"No product available",new Date());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = ProductNotSavedException.class)
    public ResponseEntity<ErrorDetails> handleProductNotSavedException(){
        ErrorDetails errorDetails= new ErrorDetails(400,"Product not saved ,Please enter valid product",new Date());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }


}
