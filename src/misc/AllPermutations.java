package demo.misc;

import java.util.*;
import java.util.stream.Collectors;

public class AllPermutations {
    static Set<String> set = new LinkedHashSet<>();
    /*
    static Comparator<String> cmp = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
//            int len = o1.length() - o2.length();
//            if (len==0)
//                return o1.compareTo(o2);
//            return len;
            return (o1.length() == o2.length()) ? o1.compareTo(o2) : o1.length() - o2.length();
        }
    };
    */

    public static void main(String[] args) {
        compound(new String[]{"a", "b", "c"});
        System.out.println(set);
        System.out.println(set.size());

        var listFromSet = set.stream()
                //.sorted(cmp)
                //.sorted(Comparator.comparing(String::length, Comparator.reverseOrder())
                // .thenComparing(String::compareTo))
                .sorted((o1, o2) -> {
                    return (o1.length() == o2.length()) ? o1.compareTo(o2) : o1.length() - o2.length();
                })
                .filter(s -> s.length() > 0)
                .collect(Collectors.toList());
        System.out.println(listFromSet);
    }

    public static void compound(String[] args) {
        var list = new ArrayList<String>(Arrays.asList(args));
        if (!set.add(String.join("", list)))
            return;
        if (args.length < 1)
            return;
        String sFirst = list.remove(0);
        compound(list.toArray(new String[0]));
        for (int i = 0; i < list.size() + 1; i++) {
            var listNew = new ArrayList<String>(list);
            listNew.add(i, sFirst);
            compound(listNew.toArray(new String[0]));
        }
    }
}
/*
[abc, bc, c, , cb, b, bac, ac, ca, a, acb, cab, ab, ba, cba, bca]
16
[a, b, c, ab, ac, ba, bc, ca, cb, abc, acb, bac, bca, cab, cba]

Foo[] array = new Foo[list.size()];
list.toArray(array); // fill the array

Note that this works only for arrays of reference types. For arrays of primitive types, use the traditional way:

List<Integer> list = ...;
int[] array = new int[list.size()];
for(int i = 0; i < list.size(); i++) array[i] = list.get(i);
 */