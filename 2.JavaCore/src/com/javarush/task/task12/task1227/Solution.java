package com.javarush.task.task12.task1227;

/* 
Fly, Run, Swim для классов Duck, Penguin, Toad
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

    public class Duck implements Fly, Run, Swim{
        @Override
        public void fly() {
            System.out.println(this + "'s flying");
        }

        @Override
        public void run() {
            System.out.println(this + "'s running");
        }

        @Override
        public void swim() {
            System.out.println(this + "'s swimming");
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName();
        }
    }

    public class Penguin implements Run, Swim {
        @Override
        public void run() {
            System.out.println(this + "'s running");
        }

        @Override
        public void swim() {
            System.out.println(this + "'s swimming");
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName();
        }
    }

    public class Toad implements Swim {
        @Override
        public void swim() {
            System.out.println(this + "'s swimming");
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName();
        }
    }
}
