package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "it's test static string";
        public int i;
        public int j;
    }

    public static void main(String[] args) {
        File file = new File("/home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2009/ClassWithStaticObject.bin");
        try (
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fis)
        ) {
            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 2;
            classWithStatic.j = 3;
            objectOutputStream.writeObject(classWithStatic);

            ClassWithStatic.staticString = "new static string";

            ClassWithStatic loadedClassWithStatic = (ClassWithStatic) objectInputStream.readObject();

            System.out.println("ClassWithStatic.staticString : " + ClassWithStatic.staticString);
            System.out.println("classWithStatic.staticString : " + classWithStatic.staticString);
            System.out.println("loadedClassWithStatic.staticString : " + loadedClassWithStatic.staticString);
            System.out.println("classWithStatic.i : " + classWithStatic.i);
            System.out.println("loadedClassWithStatic.i : " + loadedClassWithStatic.i);
            System.out.println("classWithStatic.j : " + classWithStatic.j);
            System.out.println("loadedClassWithStatic.j : " + loadedClassWithStatic.j);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
