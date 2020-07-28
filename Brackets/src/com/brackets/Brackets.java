package com.brackets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Brackets {
    /*
     * N, count - integer;
     * tempList — temp list;
     * currentList — current list;
     * temp - temp String;
     */
    private int N = 0;
    private int count = 1;
    private List<String> tempList;
    private List<String> currentList;
    private String temp;

    public Brackets() {
        tempList = new ArrayList<>();
        currentList = new ArrayList<>();
        currentList.add("()");
    }

    /**
     * This is a character check.
     * If you enter non-numeric or empty characters, an error is displayed
     * @exception NumberFormatException and the program exits.
     */
    public void start(){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Input N of open/close brackets:");
            while (true){
                String s = reader.readLine();
                if (s.matches("^\\d+$")){
                    N = Integer.parseInt(s);
                    break;
                }
                else
                    System.out.println("Wrong data! Try to again.");
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        if (N <= 0){
            System.out.println("N must be a non-negative integer");
            System.exit(1);
        } else {
            /*
             * Replaces the position of open and closed brackets
             */
            while (count < N) {
                for (String symbol : currentList) {
                    for (int i = 0; i < symbol.length(); i++) {
                        temp = symbol.substring(0, i) + "()" + symbol.substring(i);

                        if (tempList.contains(temp)) //Check for temp in tempList, if any, skip iteration.
                            continue;

                        tempList.add(temp); //add temp to tempList
                    }
                }
                // Setting before next loop
                currentList = tempList;
                tempList = new ArrayList<>(); // create empty tempList
                count++;
            }

            currentList.forEach(System.out::println); //Shows bracket options
        }
    }
}
