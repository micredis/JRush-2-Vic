package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    private static final String EXIT_TRIGGER = "сумма";

    public static void main(String[] args) {
        //напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        int sum = 0;
        String str = next();
        while (!EXIT_TRIGGER.equals(str)) {
            try {
                sum += Integer.parseInt(str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            str = next();
        }
        System.out.println(sum);
    }

    private String next() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
