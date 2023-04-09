package classes;

import java.util.*;
import java.util.stream.Collectors;

public class MainMap {
    public static void main(String[] args) {
        System.out.println("start");

//        treemap();
        sort();
        System.out.println("stop");
    }

    static void map1() {
        //sort();
        //iterate();

//        Map<String, Integer> map = new LinkedHashMap<>();
//        System.out.println(map.put("A",1));
//        System.out.println(map.put(null,2));
//        System.out.println(map.put("A",3));
//        System.out.println(map.put("A",4));
//        System.out.println(map);
//
//        var list = map.entrySet().stream().toList();
//        System.out.println(list);
//
//        var list2 = map.entrySet().stream()
//                .sorted((a,b)->a.getValue().compareTo(b.getValue())).toList();
//        System.out.println(list2);
    }

    public static void sort() {

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 2);
        map.put("c", 1);
        map.put("b", 3);
        System.out.println(map);

        List<Map.Entry> listKeys = map.entrySet().stream()
                .sorted((b, a) -> a.getKey().compareTo(b.getKey()))
                .collect(Collectors.toList());


        List<Map.Entry> listVals = map.entrySet().stream()
                .sorted((b, a) -> a.getValue().compareTo(b.getValue()))
                .collect(Collectors.toList());


        List<String> listK = map.entrySet().stream()
                .sorted((b, a) -> a.getKey().compareTo(b.getKey()))
                .map(m -> m.getKey())
                .collect(Collectors.toList());


        List<Integer> listV = map.entrySet().stream()
                .sorted((b, a) -> a.getValue().compareTo(b.getValue()))
                .map(m -> m.getValue())
                .collect(Collectors.toList());


        Map<String, Integer> map2 = map.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(1).collect(Collectors.toMap(m -> m.getKey(), m -> m.getValue()));

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        var mapFromList = list.stream()
                .collect(Collectors.toMap(i -> i, i -> String.valueOf(i)
                ,(o1,o2)->o1
        ));
        System.out.println(mapFromList);

    }

    static void iterate() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 2);
        map.put("c", 1);
        map.put("b", 3);
        System.out.println(map);

        map.forEach((k, v) -> System.out.println((k + ":" + v)));
        map.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }

        for (Integer value : map.values()) {
            System.out.println(value);
        }
    }

    static void treemap() {
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };
        var map = new TreeMap<String, Integer>(cmp);
        map.put("a3", 1);
        map.put("a2", 2);
        map.put("a1", 3);
        System.out.println(map);
    }
}
//    Comparator<Arrow> cmp = Comparator
//            .comparing(Arrow::getWeight)
//            .thenComparing(Arrow::getCount, Comparator.reverseOrder())
//            .thenComparing((a, b) -> Character.compare(a.ch, b.ch));
//listChar.sort(cmp);

