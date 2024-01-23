package designPattern.behavioral.strategy;

public class OperationDec implements Strategy{
    @Override
    public void doOperation(int i1, int i2) {
        System.out.printf("%nOperationDec: %d", i1-i2);
    }
}
