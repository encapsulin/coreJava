package designPattern.behavioral.strategy;

public class OperationMult implements Strategy{
    @Override
    public void doOperation(int i1, int i2) {
        System.out.printf("%nOperationMult: %d", i1*i2);
    }
}
