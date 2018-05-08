package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        // напишите тут ваш код
        reader.close();

        // count a number of occurrences of letters
        // in lines from the list
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (String s : list) {
            char[] sAsChars = s.toCharArray();
            for (char c : sAsChars) {
                if (!frequencyMap.containsKey(c)
                        && alphabet.contains(c)) {
                    frequencyMap.put(c, 1);
                } else if (frequencyMap.containsKey(c)
                        && alphabet.contains(c)) {
                    frequencyMap.put(c, frequencyMap.get(c) + 1);
                }
            }
        }

        for (Character character : alphabet) {
            // if a letter from the alphabet is never occurred,
            // use a default value of 0 to avoid NullPointerException
            int count = frequencyMap.getOrDefault(character, 0);
            System.out.println(String.valueOf(character) + " " + count);
        }
    }

}
