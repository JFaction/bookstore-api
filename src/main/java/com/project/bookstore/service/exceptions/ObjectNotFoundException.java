package com.project.bookstore.service.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1;

    public ObjectNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public ObjectNotFoundException(String message){
        super(message);
    }
    

}
