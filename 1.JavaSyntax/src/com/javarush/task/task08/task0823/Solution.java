package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    private static final String WHITE_SPACE = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        reader.close();
//        System.out.println(firstToUpperCase(s));
        StringBuilder sb = new StringBuilder();
        boolean isNewWord = true;
        for (int i = 0; i < s.length(); i++) {
            String sym = s.substring(i, i + 1);
            if (WHITE_SPACE.equals(sym)) {
                sb.append(sym);
                isNewWord = true;
            } else if (isNewWord) {
                sb.append(sym.toUpperCase());
                isNewWord = false;
            } else {
                sb.append(sym);
                isNewWord = false;
            }
        }
        System.out.println(sb.toString());
    }

    // it would work unless there were no "only one method" (i.e. main) restriction
    /*private static String firstToUpperCase(String s) {
        return helper(s, true);
    }

    private static String helper(String s, boolean isNewWord) {
        if (s.isEmpty()) return s;
        String sym = s.substring(0, 1);
        if (WHITE_SPACE.equals(sym)) {
            return sym + helper(s.substring(1), true);
        } else if (isNewWord) {
            return sym.toUpperCase() + helper(s.substring(1), false);
        } else {
            return sym + helper(s.substring(1), false);
        }
    }*/
}
