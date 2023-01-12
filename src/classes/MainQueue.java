package test;

import java.util.ArrayDeque;
import java.util.stream.IntStream;

public class MainQueue {

    public static void main(String[] args) {
        System.out.println("main");

        mainQue();
    }

    public static void mainQue(String... args) {
        System.out.println("mainList");

        ArrayDeque<Integer> que = new ArrayDeque<>();

        long l1 = System.currentTimeMillis();
        mainLinkedList(que);
        long l2 = System.currentTimeMillis() - l1;
        System.out.printf(" l2-l1=%d", l2);

        l1 = System.currentTimeMillis();
        mainLinkedListClean(que);
        l2 = System.currentTimeMillis() - l1;
        System.out.printf(" l2-l1=%d", l2);
        //1650
    }

    public static void mainLinkedList( ArrayDeque<Integer> que) {
        IntStream.range(0, 50_000_000).forEach(i -> {
            que.addFirst(i);
        });

    }

    public static void mainLinkedListClean( ArrayDeque<Integer> que) {
        while (que.size() > 0)
            que.pollFirst();
    }
}
