package designPattern.structural.decorator;

import designPattern.Shape;

abstract class ShapeDecorator implements Shape{

    Shape shape;

    public ShapeDecorator(Shape shape){
        this.shape = shape;
    }

    public void draw(){
        shape.draw();
    }
}
