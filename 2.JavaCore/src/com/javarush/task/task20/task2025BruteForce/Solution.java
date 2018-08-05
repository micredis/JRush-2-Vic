package com.javarush.task.task20.task2025BruteForce;

import java.util.ArrayList;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long N = 100_000_000L;
        long[] armstrongNumbers = getNumbers(N);
        for (long number : armstrongNumbers) {
            System.out.println(number);
        }
        long finish = System.currentTimeMillis();
        System.out.println("Time consumed: " + (finish - start) + " ms");
    }

    public static long[] getNumbers(long N) {
        List<Long> selectedNums = new ArrayList<>();
        for (long i = 0L; i < N; i++) {
            long sum = getPowerSum(i, orderOfMagnitude(i));
            if (sum == i)
                selectedNums.add(i);
        }
        long[] result = new long[selectedNums.size()];
        for (int i = 0; i < selectedNums.size(); i++) {
            result[i] = selectedNums.get(i);
        }
        return result;
    }

    private static long power(long x, int n) {
        long result = x;
        for (int i = 1; i < n; i++) {
            result *= x;
        }
        return result;
    }

    private static int orderOfMagnitude(long x) {
        int count = 0;
        while (x != 0) {
            count++;
            x /= 10;
        }
        return count;
    }

    private static long getPowerSum(long num, int pow) {
        long lastDigit = num % 10;
        long truncNumber = num / 10;
        if (truncNumber == 0) return power(lastDigit, pow);
        return power(lastDigit, pow) + getPowerSum(truncNumber, pow);
    }
}
