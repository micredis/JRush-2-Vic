package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream stream) throws NotSerializableException {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream stream) throws NotSerializableException {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) {
        File file = new File("/home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2021/except.ser");
        try (
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            // throws NotSerializableException
            oos.writeObject(new SubSolution());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
