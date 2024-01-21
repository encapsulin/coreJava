package designPattern.structural.proxy;

public class ProxyImage implements Image {

    String fn;
    RealImage realImage;

    public ProxyImage(String fn) {
        this.fn = fn;
        System.out.printf("ProxyImage(%s)%n", fn);
    }

    public void draw() {
        if(realImage == null)
            realImage = new RealImage(fn);
        realImage.draw();
    }

}
