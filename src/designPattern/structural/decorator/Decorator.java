package designPattern.structural.decorator;

import designPattern.Shape;

public class Decorator extends ShapeDecorator{

    public Decorator(Shape shape){
        super(shape);
    }

    @Override
    public void draw() {
        super.draw();
        drawBorder();
    }

    private void drawBorder() {
        System.out.println("drawBorder()");
    }
}
