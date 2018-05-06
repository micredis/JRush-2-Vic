package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        List<Integer> numbers = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                int num = Integer.parseInt(reader.readLine());
                numbers.add(num);
            }
        } catch (NumberFormatException ignored) {
        } catch (IOException ignored) {
        } finally {
            for (int num : numbers) {
                System.out.println(num);
            }
        }

    }
}
