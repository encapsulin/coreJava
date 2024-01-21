package designPattern.creational.singleton;

public class SingleObj {

    static SingleObj instance = new SingleObj();

    private SingleObj(){
        System.out.println("SingleObj()");
    }

    public static SingleObj getInstance(){
        return instance;
    }

    void draw(){
        System.out.println("SingleObj::draw()");
    }
}
