package designPattern.behavioral.strategy;

public class Main {
    public static void main(String[] args) {
        Context context = new Context(new OperationDec());
        context.doOperation(1,2);

        context = new Context(new OperationInc());
        context.doOperation(1,2);

        context = new Context(new OperationMult());
        context.doOperation(1,2);
    }
}
