package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().go();
    }

    private void go() throws Exception {
        int a = readInt();
        int b = readInt();
        if (a <= 0 || b <= 0) throw new Exception(); // because validator needs it
        System.out.println(gcd(a, b));
    }

    private Integer readInt() {
        Integer num = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            num = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException | NullPointerException e) {
            e.printStackTrace();
        }
        return num;
    }

    // greatest common divisor
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
