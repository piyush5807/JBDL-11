package com.example.majorproject;

public class UserException extends Exception{

    public UserException(String msg) {
        super(msg);
    }

    public UserException() {
        super("Some exception occurred while getting user details");
    }
}
