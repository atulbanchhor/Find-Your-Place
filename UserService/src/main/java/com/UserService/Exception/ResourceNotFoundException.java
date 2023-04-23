package com.UserService.Exception;

public class ResourceNotFoundException extends RuntimeException{

    // i write extra properties want to manage
    public ResourceNotFoundException(){
        super("Resource Not Found On Server !!");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
