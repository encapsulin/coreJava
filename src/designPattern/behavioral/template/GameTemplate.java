package designPattern.behavioral.template;

public abstract class GameTemplate {

    void init(){}

    void start(){}

    void stop(){}

    final void play(){
        init();
        start();
        stop();
    }

}
