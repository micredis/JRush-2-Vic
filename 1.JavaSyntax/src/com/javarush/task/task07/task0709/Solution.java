package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* 
Выражаемся покороче
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        ArrayList<String> stringList = new ArrayList<>();
        readToStringList(stringList, 5);
        printShortestString(stringList);
    }

    private void readToStringList(List<String> stringList, int numOfStrings) {
        try {
            Reader reader = new InputStreamReader(System.in);
            BufferedReader bufReader = new BufferedReader(reader);
            for (int i = 0; i < numOfStrings; i++) {
                stringList.add(bufReader.readLine());
            }
            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printShortestString(List<String> stringList) {
        int minLen = Integer.MAX_VALUE;
        for (String s : stringList)
            if (s.length() < minLen)
                minLen = s.length();
        for (String s : stringList)
            if (s.length() == minLen)
                System.out.println(s);
    }
}
