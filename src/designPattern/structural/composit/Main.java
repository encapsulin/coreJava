package designPattern.structural.composit;

public class Main {
    public static void main(String[] args) {
        Composit c1 = new Composit("c1");
        Composit c1_1 = new Composit("c1_1");
        Composit c1_2 = new Composit("c1_2");
        c1.add(c1_1);
        c1.add(c1_2);
        Composit c1_1_1 = new Composit("c1_1_1");
        Composit c1_1_2 = new Composit("c1_1_2");
        Composit c1_1_3 = new Composit("c1_1_3");
        c1_1.add(c1_1_1);
        c1_1.add(c1_1_2);
        c1_2.add(c1_1_3);

        c1.print("");
    }
}
