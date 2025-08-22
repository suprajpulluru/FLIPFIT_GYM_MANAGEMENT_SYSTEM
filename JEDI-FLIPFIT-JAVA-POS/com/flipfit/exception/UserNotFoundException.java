package com.flipfit.exception;
/*
 *@Author : "Akanksha Sharma"
 *@ClassName: "UserNotFoundException"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "java.lang.Exception"
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message){
        super(message);
    }
}
