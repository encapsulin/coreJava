package designPattern.behavioral.strategy;

public class OperationInc implements Strategy{
    @Override
    public void doOperation(int i1, int i2) {
        System.out.printf("%nOperationInc: %d", i1+i2);
    }
}
