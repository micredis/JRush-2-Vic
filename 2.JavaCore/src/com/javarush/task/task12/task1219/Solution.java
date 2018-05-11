package com.javarush.task.task12.task1219;

/* 
Создаем человека
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface Fly {
        public void fly();
    }

    public interface Run {
        public void run();
    }

    public interface Swim {
        public void swim();
    }


    public class Human implements Run, Swim {
        @Override
        public void run() {
            System.out.println("I'm running.");
        }

        @Override
        public void swim() {
            System.out.println("I'm swimming.");
        }
    }

    public class Duck implements Fly, Swim, Run {
        @Override
        public void fly() {
            System.out.println("I'm flying high like a duck in the sky.");
        }

        @Override
        public void run() {
            System.out.println("I'm running.");
        }

        @Override
        public void swim() {
            System.out.println("I'm swimming in my swimming pool.");
        }
    }

    public class Penguin implements Run, Swim {
        @Override
        public void run() {
            System.out.println("I can run!");
        }

        @Override
        public void swim() {
            System.out.println("I can swim well!");
        }
    }

    public class Airplane implements Fly, Run {
        @Override
        public void run() {
            System.out.println("Clear to take off!");
        }

        @Override
        public void fly() {
            System.out.println("I'm 30,000 feet above the ground.");
        }
    }
}
