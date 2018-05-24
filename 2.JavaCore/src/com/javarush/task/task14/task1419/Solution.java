package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.*;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            Integer.parseInt("An integer is expected here");
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }

        try {
            int[] empty = new int[0];
            empty[1] = 1;
        } catch (IndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            Map<String, Double> map = new HashMap<>();
            map.put("a", 1.0);
            map.put("b", 1.9);
            map.put("c", 2.7);
            for (String s : map.keySet()) {
                map.remove("a");
            }
        } catch (ConcurrentModificationException e) {
            exceptions.add(e);
        }

        BufferedReader reader = null;
        try {
            String fileName = "thereIsNoSuchFile.txt";
            File file = new File(fileName);
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException ignored) {
            }
        }

        try {
            String a = "a";
            String b = null;
            b.equals(a);
        } catch (NullPointerException e) {
            exceptions.add(e);
        }

        try {
            throw new NoSuchElementException("NoSuchElementException has been artificially thrown");
        } catch (NoSuchElementException e) {
            exceptions.add(e);
        }

        try {
            throw new InterruptedException("InterruptedException has been artificially thrown");
        } catch (InterruptedException e) {
            exceptions.add(e);
        }

        try {
            throw new IOException("IOException has been artificially thrown");
        } catch (IOException e) {
            exceptions.add(e);
        }

        try {
            Object o = new Solution();
            Double d = (Double) o;
        } catch (ClassCastException e) {
            exceptions.add(e);
        }

    }
}
