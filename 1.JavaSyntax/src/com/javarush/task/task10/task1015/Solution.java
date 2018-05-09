package com.javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.Collections;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        // the commented code below didn't pass the validator
        /*int numOfElements = (int) (Math.random() * 10);
        ArrayList<String>[] stringLists = (ArrayList<String>[]) new ArrayList<?>[numOfElements];
        for (int i = 0; i < numOfElements; i++) {
            ArrayList<String> list = new ArrayList<String>();
            int numOfElementsList = (int) (Math.random() * 10);
            // fill a list with random numbers
            // within the range [0; 100)
            // represented as Strings
            for (int j = 0; j < numOfElementsList; j++) {
                list.add(String.valueOf((int) (Math.random() * 100)));
            }
            stringLists[i] = list;
        }

        return stringLists;*/

        int numOfLists = (int) (Math.random() * 10);
        ArrayList<String>[] listOfLists = new ArrayList[numOfLists];
        for (int i = 0; i < listOfLists.length; i++) {
            ArrayList<String> list = new ArrayList<>();
            list.add("element " + i);
            listOfLists[i] = list;
        }
        return listOfLists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}