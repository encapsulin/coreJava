package demo.misc;

import java.util.*;

public class Compound {
    public static void main(String[] args) {
        String[] arr = new String[]{"a","b","c","d"};
        Set<String> set = new LinkedHashSet<>();
        solution(arr, set);
        System.out.println(set);
        System.out.println(set.size());
    }

    static void solution(String[] arr,  Set<String> set){
        var list = new ArrayList<>(Arrays.asList(arr));
        if(!set.add(String.join("", list)))
            return;
        String str = list.remove(0);
        for(int i=0; i<= list.size();i++){
            var listMutable = new ArrayList<String>(list);
            listMutable.add(i,str);
            solution(listMutable.toArray(new String[0]), set);
        }
    }
}
