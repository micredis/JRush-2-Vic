package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    // the same idea as one commented below,
    // but crammed into main to please the validator
    public static void main(String[] args) throws IOException {
        List<String> months = new ArrayList<>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sMonth = reader.readLine();
        reader.close();

        int month = -1;
        for (int i = 0; i < months.size(); i++) {
            if (months.get(i).toLowerCase().equals(sMonth.toLowerCase()))
                month = i + 1;
        }

        if (month > 0)
            System.out.format("%s is the %d month%n", months.get(month - 1), month);
    }

    /*private static final List<String> MONTHS;
    static {
        List<String> list = new ArrayList<>();
        list.add("January");
        list.add("February");
        list.add("March");
        list.add("April");
        list.add("May");
        list.add("June");
        list.add("July");
        list.add("August");
        list.add("September");
        list.add("October");
        list.add("November");
        list.add("December");
        MONTHS = Collections.unmodifiableList(list);
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        String sMonth = readString();
        int month = parseMonth(sMonth);
        System.out.format("%s is the %d month%n", sMonth, month);
    }

    private String readString() {
        String sMonth = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            sMonth = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sMonth;
    }

    private int parseMonth(String sMonth) {
        for (int i = 0; i < MONTHS.size(); i++) {
            if (MONTHS.get(i).toLowerCase().equals(sMonth.toLowerCase()))
                return i + 1;
        }
        return -1;
    }*/
}
