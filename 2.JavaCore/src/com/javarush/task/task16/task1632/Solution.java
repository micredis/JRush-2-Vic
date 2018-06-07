package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread(new NeverEnds()));
        threads.add(new Thread(new ThrowsInterrupted()));
        threads.add(new Thread(new Hurray()));
        threads.add(new Sms());
        threads.add(new Thread(new Summator()));
    }

    public static void main(String[] args) {
    }

    public static class NeverEnds implements Runnable {
        @Override
        public void run() {
            while (true) {}
        }
    }

    public static class ThrowsInterrupted implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Hurray implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Sms extends Thread implements Message {
        private volatile boolean isCancelled = false;

        @Override
        public void showWarning() {
            isCancelled = true;
        }

        @Override
        public void run() {
            while (!isCancelled) {
            }
        }
    }

    public static class Summator implements Runnable {
        private static final String STOP = "N";
        private int sum;

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
            try {
                line = reader.readLine();
            } catch (IOException e) {
                try {
                    reader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                e.printStackTrace();
            }
            while (!STOP.equals(line)) {
                try {
                    sum += Integer.parseInt(line);
                    line = reader.readLine();
                } catch (NumberFormatException | IOException e) {
                    try {
                        reader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    e.printStackTrace();
                }
            }
            try {
                reader.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
            System.out.println(sum);
        }
    }
}