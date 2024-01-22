package designPattern.structural.facade;

import designPattern.Circle;
import designPattern.Rectangle;

public class Facade {

    Circle circle;
    Rectangle rectangle;

    public Facade(){
        circle = new Circle();
        rectangle = new Rectangle();
    }

    void drawCircle(){
        circle.draw();
    }

    void drawRectangle(){
        rectangle.draw();
    }
}
