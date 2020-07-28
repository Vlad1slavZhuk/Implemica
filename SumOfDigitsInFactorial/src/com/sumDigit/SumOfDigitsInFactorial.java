package com.sumDigit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SumOfDigitsInFactorial {
    private int N = 0;
    private int sum = 0;
    private BigInteger integer = BigInteger.ONE;

    public void start(){
        /*
         * Reads a string and converts to an integer.
         * If the string is not numeric, exit with error code 1
         */
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Input number: ");
            N = Integer.parseInt(reader.readLine());
            if (N < 0)
                throw new IOException();
        } catch (IOException | NumberFormatException e){
            System.out.println("You entered non-digits symbols or negative integer");
            System.exit(1);
        }

        /*
         * Calculating the factorial N
         * integer — this is the result of calculating the factorial
         */
        for (int i = 2; i < N + 1; i++) {
            integer = integer.multiply(BigInteger.valueOf(i));
        }

        String num = integer.toString();

        /*
         * Character-by-character sum of numbers from variable num
         */
        for (int i = 0; i < num.length(); i++) {
            int a = Integer.parseInt(num.charAt(i) + "");
            sum += a;
        }

        System.out.println(sum); // Show sum
    }
}
