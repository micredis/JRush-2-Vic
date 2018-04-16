package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    //напишите тут ваш код
    public Circle() {
        this.x = 0.0;
        this.y = 0.0;
        this.radius = 1.0;
    }

    public Circle(Circle circle) {
        this.x = circle.x;
        this.y = circle.y;
        this.radius = circle.radius;
    }

    public Circle(double x, double y) {
        this.x = x;
        this.y = y;
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.x = 0.0;
        this.y = 0.0;
        this.radius = radius;
    }

    public static void main(String[] args) {

    }
}