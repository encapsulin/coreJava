package designPattern.creational.factory;

import designPattern.Circle;
import designPattern.Rectangle;
import designPattern.Shape;

public class Factory {

    Shape getShape(String shape){
        if(shape.equals("Rectangle"))
            return new Rectangle();
        if(shape.equals("Circle"))
            return new Circle();
        return null;
    }

}
