package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    private int a;
    private int b;
    private int c;

    public static void main(String[] args) {
        //напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        readABC();
        printEquals(this.a, this.b, this.c);
    }

    private void printEquals(int a, int b, int c) {
        if (a == b && b == c)
            System.out.println(a + " " + b + " " + c);
        else if (a == b)
            System.out.println(a + " " + b);
        else if (b == c)
            System.out.println(b + " " + c);
        else if (c == a)
            System.out.println(c + " " + a);
    }

    private void readABC() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            this.a = Integer.parseInt(reader.readLine());
            this.b = Integer.parseInt(reader.readLine());
            this.c = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}