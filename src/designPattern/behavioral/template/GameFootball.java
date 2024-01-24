package designPattern.behavioral.template;

public class GameFootball extends GameTemplate {

    @Override
    void init(){
        System.out.println("GameFootball::init()");
    }

    @Override
    void start(){
        System.out.println("GameFootball::start()");
    }

    @Override
    void stop(){
        System.out.println("GameFootball::stop()");
    }
}
