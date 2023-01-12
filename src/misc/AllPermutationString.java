package demo.misc;

import java.util.*;
import java.util.stream.Collectors;

public class AllPermutationString {

    static Set<String> set = new LinkedHashSet<String>();
    static String sAbc = "abc";

    public static void main(String[] args) {
        System.out.println("-=start=-");

        System.out.println((solution(sAbc)));

        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length())
                    return o1.compareTo(o2);

                return o1.length() - o2.length();
            }
        };

        var set3len = set.stream()
                //.filter(s->s.length()==sAbc.length())
                .sorted(cmp)
                .collect(Collectors.toList());

        System.out.println(set3len);
        System.out.println(set3len.size());

         set3len = set.stream()
                .filter(s->s.length()==sAbc.length())
                .sorted(cmp)
                .collect(Collectors.toList());

        System.out.println(set3len);
        System.out.println(set3len.size());

        System.out.println("-=stop=-");
    }

    public static int solution(String str) {
        System.out.println("solution()" + str);

        for (int i = 0; i < str.length(); i++) {
            set.add(String.valueOf(str.charAt(i)));
            addElementToEverySet(String.valueOf(str.charAt(i)));
        }
        System.out.println(set);
        return set.size();
    }

    static void addElementToEverySet(String sChar) {
        var setCopy = new HashSet<String>(set);
        for (String sFromSet : setCopy) {
            if (!sFromSet.contains(sChar)) {
                final var sFromSetList = new ArrayList<String>(Arrays.asList(sFromSet.split("")));
                for (int i = 0; i < sFromSetList.size()+1; i++) {
                    var list = new ArrayList<String>(sFromSetList);
                    list.add(i, sChar);
                    set.add(String.join("", list));
                }
            }
        }
    }
}
/*
solution()abc
[a, b, ba, ab, c, ca, ac, cab, acb, abc, cb, bc, cba, bca, bac]
15
[a, b, c, ab, ac, ba, bc, ca, cb, abc, acb, bac, bca, cab, cba]
15
[abc, acb, bac, bca, cab, cba]
6
 */