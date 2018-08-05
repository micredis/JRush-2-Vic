package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
*/
public class Solution implements Serializable {
    public A getOriginalObject(ObjectInputStream objectStream) {
        A result;
        try {
            result = (A) objectStream.readObject();
        } catch (Exception e) {
            System.out.println("Houston, we've got null");
            return null;
        }
        return result;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        A a = solution.new A();
        B b = solution.new B();
        System.out.println("Original object of the class A: " + a.getClass().getSimpleName());
        System.out.println("Original object of the class B: " + b.getClass().getSimpleName());
        File file = new File("/home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2017/temp.ser");
        try (
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fos);
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream in = new ObjectInputStream(fis)
        ) {
            out.writeObject(a);
            out.writeObject(b);
            Object loaded1 = solution.getOriginalObject(in);
            Object loaded2 = solution.getOriginalObject(in);
            Object loaded3 = solution.getOriginalObject(in);
            Object[] loadedObjects = {loaded1, loaded2, loaded3};
            for (Object loaded : loadedObjects) {
                if (loaded instanceof B) {
                    B bLoaded = (B) loaded;
                    System.out.println("Loaded object of the class B: " + bLoaded.getClass().getSimpleName());
                } else if (loaded instanceof A) {
                    A aLoaded = (A) loaded;
                    System.out.println("Loaded object of the class A: " + aLoaded.getClass().getSimpleName());
                } else {
                    System.out.println("null in the input stream");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
