package com.exception;

public class WrongDataException extends Exception{
    private String text;

    public WrongDataException(String text){
        this.text = text;
    }

    private WrongDataException(){}

    public String toString() {
        return "Wrong Data Exception: " + text;
    }
}
