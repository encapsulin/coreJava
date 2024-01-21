package designPattern.structural.proxy;

public class Main {
    public static void main(String[] args) {
        ProxyImage proxyImage = new ProxyImage("fn.txt");
        proxyImage.draw();
        proxyImage.draw();

    }
}
