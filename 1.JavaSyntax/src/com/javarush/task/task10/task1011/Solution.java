package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        //напишите тут ваш код
        cutFirstSymbolAndPrint(s, 40);
    }

    private static void cutFirstSymbolAndPrint(String s, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(s.substring(i));
        }
    }

}

