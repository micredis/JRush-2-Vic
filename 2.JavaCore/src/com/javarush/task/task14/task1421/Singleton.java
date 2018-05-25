package com.javarush.task.task14.task1421;

public final class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return Singleton.INSTANCE;
    }
}
