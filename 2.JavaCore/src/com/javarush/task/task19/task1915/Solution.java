package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        // /home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1915/output.txt
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = consoleReader.readLine();
            PrintStream consoleStream = System.out;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream baosStream = new PrintStream(baos);
            System.setOut(baosStream);
            testString.printSomething();
            System.setOut(consoleStream);
            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                fos.write(baos.toByteArray());
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

