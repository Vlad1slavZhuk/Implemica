package com.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String text){
        System.out.println(text);
    }

    public static String readString(){
        try {
            return reader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        return "";
    }

    public static int readInteger(){
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e){
            writeMessage("You input non-numeric symbol.");
            e.printStackTrace();
        }
        return 0;
    }
}
