package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        Solution solution = new Solution();
        String url = solution.readInput();
        solution.printParameters(url);
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }

    private boolean isDouble(String s) {
        return s.matches("-?\\d*\\.?\\d*");
    }

    private String readInput() {
        String url = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            url = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }

    private void printParameters(String url) {
        if (!url.contains("?")) return;
        int startIndex = url.indexOf("?") + 1;
        String paramString = url.substring(startIndex);
        String[] params = paramString.split("&");
        for (int i = 0; i < params.length; i++) {
            String param = (i < params.length - 1) ?
                    params[i].split("=")[0] + " " :
                    params[i].split("=")[0];
            System.out.print(param);
        }
        System.out.println();
        if (paramString.contains("obj=")) {
            int objValueStart = paramString.indexOf("obj=") + 4;
            int objValueEnd = paramString.indexOf("&", objValueStart);
            String objValue = paramString.substring(objValueStart, objValueEnd);
            if (isDouble(objValue))
                alert(Double.parseDouble(objValue));
            else
                alert(objValue);
        }
    }
}
