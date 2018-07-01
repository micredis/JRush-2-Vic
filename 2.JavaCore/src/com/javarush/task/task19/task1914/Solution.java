package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(baos);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);
        String result = performOperation(baos.toString());
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }

    private static String performOperation(String input) {
        int result;
        String[] splitInput = input.split(" ");
        int operand1 = Integer.parseInt(splitInput[0]);
        int operand2 = Integer.parseInt(splitInput[2]);
        String operation = splitInput[1];
        switch (operation) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            default:
                throw new NumberFormatException();
        }
        return String.format("%d %s %d = %d", operand1, operation, operand2, result);
    }
}

