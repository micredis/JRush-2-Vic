package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) {
        //напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        String text = "";
        try {
            text = readConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] vowelsAndNonVowels = splitVowels(text);
        System.out.println(vowelsAndNonVowels[0]);
        System.out.println(vowelsAndNonVowels[1]);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }

    private String readConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        reader.close();
        return line;
    }

    private String[] splitVowels(String text) {
        StringBuilder vowels = new StringBuilder();
        StringBuilder nonVowels = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (isVowel(c)) {
                vowels.append(String.valueOf(c));
                vowels.append(" ");
            } else if (c != ' ') {
                nonVowels.append(String.valueOf(c));
                nonVowels.append(" ");
            }
        }
        String[] result = {vowels.toString(), nonVowels.toString()};
        return result;
    }
}