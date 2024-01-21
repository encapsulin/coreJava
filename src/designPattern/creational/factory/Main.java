package designPattern.creational.factory;

import designPattern.Shape;

public class Main {

    public static void main(String[] args) {
        Factory factory = new Factory();
        Shape shape = factory.getShape("Rectangle");
        shape.draw();
        shape = factory.getShape("Circle");
        shape.draw(); 
    }
}
