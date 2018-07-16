package com.javarush.task.task20.task2015;

import java.io.*;
import java.util.concurrent.TimeUnit;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable {
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println(i + " " + this);
                TimeUnit.SECONDS.sleep(this.speed);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Thread loadedRunner = new Thread(this);
        loadedRunner.start();
    }

    public static void main(String[] args) {
        Solution solution = new Solution(1);
        File file = new File("/home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2015/temp.ser");
        try (
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fos);
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream in = new ObjectInputStream(fis)
        ) {
            out.writeObject(solution);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Solution loadedSolution = (Solution) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
