package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Solution solution = new Solution();
        solution.countEvensAndOdds(solution.readNumber());
        System.out.format("Even: %d Odd: %d%n", even, odd);
    }

    private void countEvensAndOdds(long number) {
        if (number == 0) {
            return;
        }
        if (number % 10 % 2 == 0) {
            even++;
            countEvensAndOdds(number / 10);
        }
        else {
            odd++;
            countEvensAndOdds(number / 10);
        }
    }

    private long readNumber() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            long num = Long.parseLong(reader.readLine());
            reader.close();
            return num;
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
