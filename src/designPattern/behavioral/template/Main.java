package designPattern.behavioral.template;

public class Main {

    public static void main(String[] args) {
        GameTemplate game = new GameFootball();
        game.play();

        game = new GameCricket();
        game.play();
    }
}
