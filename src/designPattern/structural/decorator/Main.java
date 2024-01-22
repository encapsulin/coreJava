package designPattern.structural.decorator;

import designPattern.Circle;
import designPattern.Shape;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();

        System.out.println();

        RedShapeDecorator circleDecorator = new RedShapeDecorator(circle);
        circleDecorator.draw();
    }
}
