package com.javarush.task.task04.task0410;

/* 
Попадём-не-попадём
*/

public class Solution {
    public static void main(String[] args) {
        checkInterval(60);
        checkInterval(112);
    }

    public static void checkInterval(int a) {
        //напишите тут ваш код
        String result = (a < 50 || a > 100) ? " не " : " ";
        System.out.println("Число " + a + result + "содержится в интервале.");
    }
}