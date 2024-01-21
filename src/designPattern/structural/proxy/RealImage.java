package designPattern.structural.proxy;

public class RealImage implements Image {

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
