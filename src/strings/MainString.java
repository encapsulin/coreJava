package javaCore;

import java.util.ArrayList;
import java.util.List;

public class MainString {
    public static void main(String[] args) {
        String str = "Hello world!";

        var list1 = new ArrayList<String>();
        list1.add(str);
        System.out.println(list1);

        var list2 = List.of(str.toCharArray());
        System.out.println(list2);

        var list3 = List.of(str.split(""));
        System.out.println(list3);

        System.out.println(str);
    }
}