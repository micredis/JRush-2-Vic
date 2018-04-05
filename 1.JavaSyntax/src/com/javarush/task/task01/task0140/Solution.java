package com.javarush.task.task01.task0140;

import java.util.InputMismatchException;
import java.util.Scanner;

/* 
Выводим квадрат числа
*/

public class Solution {
    public static void main(String[] args) {
        int a = 0;
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        try {
            a = sc.nextInt();
        } catch (InputMismatchException ex) {
            System.err.println("Integer is expected.");
            System.exit(-1);
        }
        System.out.println(a * a);
    }
}