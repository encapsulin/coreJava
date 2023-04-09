package classes;

import java.util.List;
import java.util.stream.Collectors;

public class MainStream {
    public static void main(String[] args) {
        asdf();
    }

    static void asdf(){
        var list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        var listR = list.stream()
                .filter(i -> i % 2 == 0)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(listR);
    }
}
