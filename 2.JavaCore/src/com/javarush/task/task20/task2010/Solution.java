package com.javarush.task.task20.task2010;

import java.io.*;

/*
Как сериализовать что-то свое?
*/
public class Solution {
    public static class Object implements Serializable {
        public String string1;
        public String string2;
    }

    public static int countStrings;

    public static class String implements Serializable {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }

    public static void main(java.lang.String[] args) {
        File file = new File("/home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2010/SolutionObjectObject.bin");
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            Solution.Object solObj = new Solution.Object();
            solObj.string1 = new Solution.String();
            solObj.string2 = new Solution.String();
            objectOutputStream.writeObject(solObj);
            System.out.println("Original object's strings' states: ");
            solObj.string1.print();
            solObj.string2.print();

            System.out.println();

            Solution.Object restoredSolObj = (Solution.Object) objectInputStream.readObject();
            System.out.println("Recovered object's strings' states: ");
            restoredSolObj.string1.print();
            restoredSolObj.string2.print();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
