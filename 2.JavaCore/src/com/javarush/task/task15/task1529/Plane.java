package com.javarush.task.task15.task1529;

public class Plane implements Flyable {
    private int numOfPassengers;

    public Plane(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    @Override
    public void fly() {
        System.out.println("Plane is flying");
    }
}
