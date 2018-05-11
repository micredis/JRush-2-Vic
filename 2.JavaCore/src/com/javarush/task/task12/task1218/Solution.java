package com.javarush.task.task12.task1218;

/* 
Есть, летать и двигаться
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface Fly {
        public void fly();
    }

    public interface Move {
        public void move();
    }

    public interface Eat {
        public void eat();
    }

    public class Dog implements Move, Eat {
        @Override
        public void move() {
            System.out.println("I like to move it, move it!");
        }

        @Override
        public void eat() {
            System.out.println("Eat at home!");
        }
    }

    public class Duck implements Fly, Move, Eat {
        @Override
        public void fly() {
            System.out.println("I believe I can fly!");
        }

        @Override
        public void move() {
            System.out.println("I like to move it, move it!");
        }

        @Override
        public void eat() {
            System.out.println("Eat at home!");
        }
    }

    public class Car implements Move {
        @Override
        public void move() {
            System.out.println("Beep, beep, be-beep, yeah!");
        }
    }

    public class Airplane implements Fly, Move {
        @Override
        public void move() {
            System.out.println("I'm moving along the runway.");
        }

        @Override
        public void fly() {
            System.out.println("Take off!");
        }
    }
}
