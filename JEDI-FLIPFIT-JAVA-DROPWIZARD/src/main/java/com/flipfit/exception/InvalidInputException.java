package com.flipfit.exception;
/*
 *@Author : "Gaurav"
 *@ClassName: "GymNotFoundException"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "java.lang.Exception"
 */
public class InvalidInputException extends Exception {
    public InvalidInputException(String message){
        super(message);
    }
}