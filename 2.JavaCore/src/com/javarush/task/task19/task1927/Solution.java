package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        new Solution().go();
    }

    private void go() {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(baos);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);
        String[] lines = getLines(baos);
        for (int i = 0; i < lines.length; i++) {
            if ((i + 1) % 2 == 0) {
                System.out.print(lines[i]);
                System.out.println("JavaRush - курсы Java онлайн");
            } else {
                System.out.print(lines[i]);
            }
        }
    }

    private String[] getLines(ByteArrayOutputStream baos) {
        List<String> lines = new ArrayList<>();
        String string = baos.toString();
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != 10) {
                line.append(string.charAt(i));
            } else {
                line.append(string.charAt(i));
                lines.add(line.toString());
                line.setLength(0);
            }
        }
        return lines.toArray(new String[0]);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
