package com.lgy.spring_ex5_1;

public class CircleInfo {
    private Circle circle;

    // 생성자 주입 방식
    public CircleInfo(Circle circle) {
        this.circle = circle;
    }

    public void getCircleInfo() {
        if (circle != null) {
            System.out.println("반지름 : " + circle.getRadius());
            System.out.println("원의 면적은 : " + circle.process());
        }
    }
}
