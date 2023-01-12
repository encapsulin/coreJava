package classes;

import java.util.*;
import java.util.stream.Collectors;

public class MainStringChar {
    public static void main(String[] args) {
        String str = "Hello world!";

        var list1 = new ArrayList<String>();
        list1.add(str);
        System.out.println(list1);

        var list2 = List.of(str.toCharArray());
        System.out.println(list2);

        var list3 = List.of(str.split(""));
        System.out.println(list3);

        char[] cArray = str.toCharArray();
        var list4 = Arrays.asList(cArray);
//        ArrayList<Character> list5= new ArrayList<>(list4);
        System.out.println(list4);

        int[] nums = new int[] { 1, 2, 3 };
        Integer[] nums2 = new Integer[] { 1, 2, 3 };
        var list5 = Arrays.stream(nums2).collect(Collectors.toList());
        System.out.println(list5);

        var list = str.chars().sorted().boxed().collect(Collectors.toList());
        System.out.println(list);
    }


}

