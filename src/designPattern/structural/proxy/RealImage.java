package designPattern.structural.proxy;

import designPattern.Shape;

public class RealImage implements Shape {

    String fn;

    public RealImage(String fn) {
        this.fn = fn;
        System.out.printf("RealImage(%s)%n", fn);
        this.load(this.fn);
    }

    public void load(String fn){
        System.out.printf("load(%s)%n", fn);
    }
    public void draw() {
        System.out.println("draw()");
    }

}
