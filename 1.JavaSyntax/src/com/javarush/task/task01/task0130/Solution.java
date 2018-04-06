package com.javarush.task.task01.task0130;

/* 
Наш первый конвертер!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertCelsiumToFahrenheit(41));
    }

    private static double convertCelsiumToFahrenheit(int celsium) {
        //напишите тут ваш код
        return 9.0 / 5.0 * celsium + 32;
    }
}