package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainArrayList {
    public static void main(String[] args) {
        System.out.println("start");
        List<Integer> list = new ArrayList(Arrays.asList(1,3,2,5,4));
        System.out.println(list);
        list.sort((b,a)->a-b);
        System.out.println(list);

        long sum = list.stream().mapToInt(i->i).count();
        System.out.println(sum);

        System.out.println(list.remove((Integer)1));
        System.out.println(list.remove((Integer)1));
        System.out.println(list.remove(1));
        System.out.println(list);

        System.out.println("stop");
    }
}
