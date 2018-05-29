package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        if (n < 0) return "0";
        if (n == 0 || n == 1) return "1";
        BigDecimal n1 = new BigDecimal(String.valueOf((long) n));
        BigDecimal n2 = new BigDecimal(factorial(n - 1));
        return (n1.multiply(n2)).toString();
    }
}
