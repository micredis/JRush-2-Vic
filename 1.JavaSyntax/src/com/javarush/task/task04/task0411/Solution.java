package com.javarush.task.task04.task0411;

/* 
Времена года на Терре
*/

public class Solution {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int month) {
        //напишите тут ваш код
        String sMonth;
        if (month == 12 || month < 3) {
            sMonth = "зима";
        } else if (month < 6) {
            sMonth = "весна";
        } else if (month < 9) {
            sMonth = "лето";
        } else {
            sMonth = "осень";
        }
        System.out.println(sMonth);
    }
}