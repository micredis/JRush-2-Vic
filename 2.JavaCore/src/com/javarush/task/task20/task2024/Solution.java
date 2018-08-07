package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) {
        Solution s1 = new Solution();
        s1.node = 1;
        Solution s2 = new Solution();
        s2.node = 2;
        Solution s3 = new Solution();
        s3.node = 3;
        Solution s4 = new Solution();
        s4.node = 4;
        Solution s5 = new Solution();
        s5.node = 5;
        Solution s6 = new Solution();
        s6.node = 6;

        s1.edges.add(s2);
        s2.edges.add(s2);
        s2.edges.add(s4);
        s2.edges.add(s5);
        s5.edges.add(s4);
        s4.edges.add(s5);
        s4.edges.add(s1);
        s6.edges.add(s3);

        File file = new File("/home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2024/temp.ser");
        try (
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            oos.writeObject(s1);
            oos.writeObject(s2);
            oos.writeObject(s3);
            oos.writeObject(s4);
            oos.writeObject(s5);
            oos.writeObject(s6);

            for (int i = 0; i < 6; i++) {
                Solution sLoad = (Solution) ois.readObject();
                System.out.println("node " + sLoad.node);
                System.out.println(sLoad.edges.toString());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
