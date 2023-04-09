package misc;

import java.util.*;
import java.util.stream.Collectors;

public class CombiTest11mins {

    static Comparator<String> cmp = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    };
    static Set set;

    static {
        set = new TreeSet<String>();
    }

    public static void main(String[] args) {
        combi(new String[]{"1", "2", "3"});
        System.out.println(set);

        var list = new ArrayList<>(set.stream().toList());
        Collections.sort(list, cmp);
        System.out.println(list);
    }

    private static void combi(String[] strings) {
        for (String s : strings) {
            var list = new ArrayList<String>(Arrays.asList(strings));
            int cnt = list.size();
            list.remove(s);
            for (int i = 0; i < cnt; i++) {
                var listNew = new ArrayList<String>(list);
                listNew.add(i, s);
                if (set.add(String.join("", listNew)))
                    combi(listNew.toArray(new String[0]));
            }
        }
    }
}
/*
[1 2 3]
1
[2 3]
 */