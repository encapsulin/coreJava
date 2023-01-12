package demo.collections;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MainSet {
    public static void main(String[] args) {
        System.out.println("start");
        Set<String> set = new HashSet<String>(Set.of("b","c","a"));
        set.add(null);
        System.out.println(set);
        List<String> list =set.stream()
                //.sorted((b,a)->a.compareTo(b))
                .collect(Collectors.toList());
        System.out.println(list);
        System.out.println("stop");
    }
}
