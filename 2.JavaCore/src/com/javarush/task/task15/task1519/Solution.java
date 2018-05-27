package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Pattern;

/* 
Разные методы для разных типов
*/

public class Solution {
    private static final String EXIT = "exit";

    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!(input = reader.readLine()).equals(EXIT)) {
            if (input.matches("(-?)([0-9]*)(\\.)([0-9]*)")) {
                print(Double.parseDouble(input));
            } else if (input.matches("-?\\d+")) {
                int i = Integer.parseInt(input);
                if (i > 0 && i < 128) {
                    print((short) i);
                } else {
                    print(i);
                }
            } else {
                print(input);
            }
        }
        reader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
