package misc;

import java.util.ArrayList;
import java.util.List;

public class TestArraySplit {

    static List<List> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] arry = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        splt(arry, 3);
        System.out.println(list);

    }

    private static void splt(int[] arry, int itemsPerPage) {
        var sublist = new ArrayList<>();
        for (int i = 0; i < arry.length; i++) {
            if (i % itemsPerPage == 0 && i>0) {
                list.add(sublist);
                sublist = new ArrayList<>();
            }
            sublist.add(arry[i]);
            Integer[] asdf = sublist.toArray(new Integer[0]);
        }
        list.add(sublist);
    }
}
