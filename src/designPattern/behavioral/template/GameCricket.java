package designPattern.behavioral.template;

public class GameCricket extends GameTemplate {

    @Override
    void init(){
        System.out.println("GameCricket::init()");
    }

    @Override
    void start(){
        System.out.println("GameCricket::start()");
    }

    @Override
    void stop(){
        System.out.println("GameCricket::stop()");
    }
}
