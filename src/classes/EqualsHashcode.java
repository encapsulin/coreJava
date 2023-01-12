package demo.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

class EqualsHashcode{
    public static void main(String[] args) {
        testSet();
//        testMap();
    }

    private static void testMap() {
        var map = new HashMap<A,Integer>();
        map.put(new A(1,"a"), 1);
        map.put(new A(1,"a"), 2);
        map.put(new A(2,"b"), 3);
    }

    private static void testSet() {
        var set = new HashSet<A>();
        set.add(new A(1,"a"));
        set.add(new A(1,"a"));
        set.add(new A(1,"b"));
        set.add(null);
//        set.forEach(System.out::println);
        System.out.println(set);
    }
}

class A{
    int id;
    String title;

    public A(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals()");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return id == a.id && title.equals(a.title);
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode()");
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "A{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}