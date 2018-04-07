package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    private static final String EVEN = "четное ";
    private static final String ODD = "нечетное ";
    private static final String ONE_DIG = "однозначное число";
    private static final String TWO_DIG = "двузначное число";
    private static final String THREE_DIG = "трехзначное число";

    public static void main(String[] args) {
        //напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        int num = readInt();
        int len = String.valueOf(num).toCharArray().length;
        if (num > 0 && num < 1000) {
            if (num % 2 == 0)
                System.out.print(EVEN);
            else
                System.out.print(ODD);
            if (len == 1)
                System.out.println(ONE_DIG);
            else if (len == 2)
                System.out.println(TWO_DIG);
            else
                System.out.println(THREE_DIG);
        }
    }

    private int readInt() {
        int n = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return n;
    }
}
