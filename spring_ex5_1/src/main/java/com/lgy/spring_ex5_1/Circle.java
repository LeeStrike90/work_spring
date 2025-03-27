package com.lgy.spring_ex5_1;

public class Circle {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public double process() {
        return 3.14 * radius * radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
