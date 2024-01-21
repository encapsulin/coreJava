package designPattern.creational.singleton;

public class Main {

    public static void main(String[] args) {
        SingleObj obj = SingleObj.getInstance();
        obj.draw();

        obj = SingleObj.getInstance();
        obj.draw();
    }
}
