package com.library.exception;


@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(String message, Exception ex) {
        super(message, ex);
    }

    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException() {}


}






