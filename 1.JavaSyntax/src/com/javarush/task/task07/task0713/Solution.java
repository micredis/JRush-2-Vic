package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> multiplesOf3 = new ArrayList<>();
        ArrayList<Integer> multiplesOf2 = new ArrayList<>();
        ArrayList<Integer> nonMultiples = new ArrayList<>();
        readIntsToList(list, 20);
        extractMultiples(list, multiplesOf3, multiplesOf2, nonMultiples);
        printList(multiplesOf3);
        printList(multiplesOf2);
        printList(nonMultiples);
    }

    private void readIntsToList(List<Integer> list, int numOfElements) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (int i = 0; i < numOfElements; i++) {
                list.add(Integer.parseInt(reader.readLine()));
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void extractMultiples(List<Integer> list,
                                  List<Integer> multiplesOf3,
                                  List<Integer> multiplesOf2,
                                  List<Integer> nonMultiples) {
        for (int num : list) {
            if (num % 3 == 0)
                multiplesOf3.add(num);
            if (num % 2 == 0)
                multiplesOf2.add(num);
            if (num % 3 != 0 && num % 2 != 0)
                nonMultiples.add(num);
        }
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (int i : list)
            System.out.println(i);
    }
}
