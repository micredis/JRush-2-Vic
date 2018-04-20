package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        ArrayList<String> stringList = new ArrayList<>();
        readStringsToList(stringList, 5);
        moveLastStringFirst(stringList, 13);
        printStringList(stringList);
    }

    private void readStringsToList(List<String> stringList, int numOfStrings) {
        try {
            Reader isr = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(isr);
            for (int i = 0; i < numOfStrings; i++) {
                stringList.add(reader.readLine());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void moveLastStringFirst(List<String> stringList, int repetitions) {
        for (int i = 0; i < repetitions; i++) {
            int lastIndex = stringList.size() - 1;
            stringList.add(0, stringList.remove(lastIndex));
        }
    }

    private void printStringList(List<String> stringList) {
        for (String s : stringList)
            System.out.println(s);
    }
}
