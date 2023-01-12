package speedCalc;

import java.util.*;

public class MainCollections {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("-=start=-");

        var arrayList = new ArrayList<Integer>();
        var arrayDeque = new ArrayDeque<Integer>();
        var linkedList = new LinkedList<Integer>();

        System.out.println("///////////////////////////////");

        int iLimit = 1000_000;

        addFirst(iLimit, arrayDeque);
        removeFirst(arrayDeque);

        addFirst(iLimit, linkedList);
        removeFirst(linkedList);

        addFirst(50_000, arrayList);
        removeFirst(arrayList);

        System.out.println("///////////////////////////////");

        iLimit = 1000_000;
        addLast(iLimit, arrayList);
        removeLast(arrayList);

        addLast(iLimit, arrayDeque);
        removeLast(arrayDeque);

        addLast(iLimit, linkedList);
        removeLast(linkedList);

        System.out.println("///////////////////////////////");

        iLimit = 50_000;
        addMiddle(iLimit, arrayList);
        removeMiddle(iLimit, arrayList);

        addMiddle(iLimit, linkedList);
        removeMiddle(iLimit, linkedList);

        addMiddle(iLimit, arrayDeque);


        System.out.println("-=stop=-");
    }

    static void addFirst(int iLimit_, Collection<Integer> list) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            int iLimit = iLimit_;
            System.out.print("addFirst()" + list.getClass());

            long l1 = System.currentTimeMillis();
            while (iLimit-- > 0) {
                if (list instanceof ArrayDeque<Integer>)
                    ((ArrayDeque<Integer>) list).addFirst(iLimit);
                if (list instanceof LinkedList<Integer>)
                    ((LinkedList<Integer>) list).addFirst(iLimit);
                if (list instanceof ArrayList<Integer>)
                    ((ArrayList<Integer>) list).add((int) 0, iLimit);
            }

            System.out.print(list.size());
            long l2 = System.currentTimeMillis();
            System.out.printf(": %d ms %n", l2 - l1);
//        TimeUnit.SECONDS.sleep(1);
        }
    }

    static void removeFirst(Collection<Integer> list) {
        System.out.print("removeFirst()" + list.getClass());
        long l1 = System.currentTimeMillis();
        while (list.size() > 0) {
            if (list instanceof ArrayDeque<Integer>)
                ((ArrayDeque<Integer>) list).removeFirst();
            else if (list instanceof LinkedList<Integer>)
                ((LinkedList<Integer>) list).removeFirst();
            else if (list instanceof ArrayList<Integer>)
                ((ArrayList<Integer>) list).remove((int) 0);
        }
        long l2 = System.currentTimeMillis();
        System.out.printf(": %d ms %n%n", l2 - l1);
    }
    /////////////////////////////////////////////////////////////

    static void addLast(int iLimit_, Collection<Integer> list) {
        for (int i = 0; i < 5; i++) {
            int iLimit = iLimit_;
            System.out.print("addLast()" + list.getClass());
            long l1 = System.currentTimeMillis();
            while (iLimit-- > 0) {
                list.add(iLimit);
            }
            System.out.print(list.size());
            long l2 = System.currentTimeMillis();
            System.out.printf(": %d ms %n", l2 - l1);
        }
    }

    static void removeLast(Collection<Integer> list) {
        System.out.print("removeLast()" + list.getClass());
        long l1 = System.currentTimeMillis();

        while (list.size() > 0) {

            if (list instanceof ArrayDeque<Integer>)
                ((ArrayDeque<Integer>) list).removeLast();
            if (list instanceof LinkedList<Integer>)
                ((LinkedList<Integer>) list).removeLast();
            if (list instanceof ArrayList<Integer>)
                ((ArrayList<Integer>) list).remove((int) list.size() - 1);

        }
        long l2 = System.currentTimeMillis();
        System.out.printf(": %d ms %n%n", l2 - l1);
    }

    //////////////////////////////////////////////


    static void addMiddle(int iLimit_, Collection<Integer> list) {
        System.out.print("addMiddle()" + list.getClass());
        long l1 = System.currentTimeMillis();
        while (iLimit_-- > 0) {
            int middle = list.size() / 2;

            if (list instanceof ArrayList<Integer>)
                ((ArrayList<Integer>) list).add(middle, iLimit_);
            else if (list instanceof LinkedList<Integer>)
                ((LinkedList<Integer>) list).add(middle, iLimit_);
            else if (list instanceof ArrayDeque<Integer>) {

                var listCopy = new ArrayList<Integer>(list);
                listCopy.add(middle, iLimit_);
                list.clear();
                for (Integer val : listCopy)
                    list.add(val);
            }
        }
        System.out.print(list.size());
        long l2 = System.currentTimeMillis();
        System.out.printf(": %d ms %n", l2 - l1);
    }


    static void removeMiddle(int iLimit_, Collection<Integer> list) {
        System.out.print("removeMiddle()" + list.getClass());
        long l1 = System.currentTimeMillis();
        while (iLimit_-- > 0) {
            int middle = list.size() / 2;
            if (list instanceof LinkedList<Integer>)
                ((LinkedList<Integer>) list).remove(middle);
            else if (list instanceof ArrayList<Integer>)
                ((ArrayList<Integer>) list).remove((int) middle);
            else if (list instanceof ArrayDeque<Integer>) {
                var newDeq = new ArrayDeque<Integer>();
                int ls = 0;
                while (list.size() > 0) {
                    Integer i = ((ArrayDeque<Integer>) list).removeLast();
                    if (ls++ != middle)
                        newDeq.addLast(i);
                }
                list = newDeq;
            }
        }
        long l2 = System.currentTimeMillis();
        System.out.printf(": %d ms %n%n", l2 - l1);
    }


}