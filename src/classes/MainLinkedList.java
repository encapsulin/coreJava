package demo.collections;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class MainLinkedList {

    public static void main(String[] args) {
        System.out.println("start");

        mainList();

        System.out.println("stop");
    }

    public static void mainList(String... args) {
        System.out.println("mainList");

        LinkedList<Integer> list = new LinkedList<>();

        long l1 = System.currentTimeMillis();
        mainLinkedList(list);
        long l2 = System.currentTimeMillis() - l1;
        System.out.printf(" l2-l1=%d", l2);

        l1 = System.currentTimeMillis();
        mainLinkedListClean(list);
        l2 = System.currentTimeMillis() - l1;
        System.out.printf(" l2-l1=%d", l2);
        //1650
    }

    public static void mainLinkedList(LinkedList<Integer> list) {
        IntStream.range(0, 50_000_000).forEach(i -> {
            list.addFirst(i);
        });

    }

    public static void mainLinkedListClean(LinkedList<Integer> list) {
        while (list.size() > 0)
            list.pollFirst();
    }
}
