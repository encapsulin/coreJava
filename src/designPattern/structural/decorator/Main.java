package designPattern.structural.decorator;

import designPattern.Circle;
import designPattern.Shape;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();

        System.out.println();

        Decorator circleDecorator = new Decorator(circle);
        circleDecorator.draw();
    }
}
