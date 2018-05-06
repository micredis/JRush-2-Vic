package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        String formattedDate = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Date date = new Date(reader.readLine());
            formattedDate = dateFormat.format(date).toUpperCase();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(formattedDate);
    }
}
