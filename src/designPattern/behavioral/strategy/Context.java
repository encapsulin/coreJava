package designPattern.behavioral.strategy;

public class Context {

    Strategy op;
    public Context(Strategy op){
        this.op = op;
    }
    public void doOperation(int i1, int i2) {
        op.doOperation(i1,i2);
    }
}
