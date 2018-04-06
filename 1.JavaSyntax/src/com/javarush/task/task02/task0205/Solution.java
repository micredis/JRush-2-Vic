package com.javarush.task.task02.task0205;

/* 
Прибавка к зарплате
*/
public class Solution {
    public static void main(String[] args) {
        salary(700);
    }

    private static void salary(int a) {
        //напишите тут ваш код
        System.out.format("Твоя зарплата составляет: %d долларов в месяц.%n", a + 100);
    }
}
