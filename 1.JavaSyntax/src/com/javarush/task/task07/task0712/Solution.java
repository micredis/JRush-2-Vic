package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        ArrayList<String> stringList = new ArrayList<>();
        readStringsToList(stringList, 10);
        printShortestOrLongestString(stringList);
    }

    private void readStringsToList(List<String> stringList, int numOfStrings) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (int i = 0; i < numOfStrings; i++) {
                stringList.add(reader.readLine());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printShortestOrLongestString(List<String> stringList) {
        int minStrLen = Integer.MAX_VALUE;
        int maxStrLen = Integer.MIN_VALUE;
        String shortest = "";
        String longest = "";
        int iShortest = 0;
        int iLongest = 0;
        for (int i = 0; i < stringList.size(); i++) {
            String s = stringList.get(i);
            if (s.length() < minStrLen) {
                minStrLen = s.length();
                shortest = s;
                iShortest = i;
            }
            if (s.length() > maxStrLen) {
                maxStrLen = s.length();
                longest = s;
                iLongest = i;
            }
        }
        System.out.println(iShortest < iLongest ? shortest : longest);
    }
}
