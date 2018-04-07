package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    private static final String NEGATIVE = "отрицательное ";
    private static final String POSITIVE = "положительное ";
    private static final String ZERO = "ноль";
    private static final String EVEN = "четное число";
    private static final String ODD = "нечетное число";

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        reader.close();
        String result = "";
        if (num < 0) {
            result += NEGATIVE;
        } else if (num > 0) {
            result += POSITIVE;
        } else {
            result += ZERO;
        }
        if (num != 0 && num % 2 == 0) {
            result += EVEN;
        } else if (num != 0) {
            result += ODD;
        }
        System.out.println(result);
    }
}
