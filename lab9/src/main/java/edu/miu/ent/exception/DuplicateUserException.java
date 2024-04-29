package edu.miu.ent.exception;

public class DuplicateUserException extends Exception{
    public DuplicateUserException(String message){
        super(message);
    }
}
