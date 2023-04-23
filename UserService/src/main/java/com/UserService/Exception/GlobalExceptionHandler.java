package com.UserService.Exception;

import com.UserService.Payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice = @ControllerAdvice + @ResponseBody .
// Keeping in mind that @RestControllerAdvice is more convenient annotation for handling Exception with RestfulApi.
// In that case any exception instanceOf CustomNotFoundException will be thrown in body of response.
// kabhi bhi pure program m kahi exception aayega to ye handle karega
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){             // responce entity is inbuilt class
        String message = ex.getMessage();
        ApiResponse response=ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
    }
}

