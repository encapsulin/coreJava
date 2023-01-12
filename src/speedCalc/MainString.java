package speedCalc;

import java.util.*;
import java.util.stream.Collectors;

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

        char[] cArray = str.toCharArray();
        var list4 = Arrays.asList(cArray);
//        ArrayList<Character> list5= new ArrayList<>(list4);
        System.out.println(list4);

//        int[] nums = new int[] { 1, 2, 3 };
//        Integer[] nums2 = new Integer[] { 1, 2, 3 };
//        var list5 = Arrays.stream(nums2).collect(Collectors.toList());
//        System.out.println(list5);

        str = randomString(1000_000_00);
        System.out.println(str.length());
        countChars1(str);
        countChars2(str);
    }

    static void countChars1(String str){
        System.out.print("speedCalc()" + str.length());
        long l1 = System.currentTimeMillis();

        var map = new HashMap<Character,Integer>();
        for(Character c: str.toCharArray()){
            Integer cnt = map.get(c);
            if(cnt == null)
                cnt = 0;
            map.put(c,++cnt);
        }

        long l2 = System.currentTimeMillis();
        System.out.printf(": %d ms %n", l2 - l1);
        System.out.println(map);
    }

    static void countChars2(String str){
        System.out.print("speedCalc()" + str.length());
        long l1 = System.currentTimeMillis();

        var map = new HashMap<Character,Integer>();
        for(int i=0; i< str.length();i++){
            Character c = str.charAt(i);
            Integer cnt = map.get(c);
            if(cnt == null)
                cnt = 0;
            map.put(c,++cnt);
        }

        long l2 = System.currentTimeMillis();
        System.out.printf(": %d ms %n", l2 - l1);
        System.out.println(map);
    }


    static String randomString(int len) {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        int iBounds = 'z' - 'a' +1;
//        int i1 = (int)'0';
        while (len-- > 0) {
            int iRnd = rnd.nextInt(iBounds);
            char c = (char) ('a' + iRnd);
            sb.append(c);
        }
        return sb.toString();
    }

    public static Character firstNonRepeatedChar(String input) {
//        System.out.println(input);
        List<Character> list = new ArrayList<>();
        var map = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < input.length(); i++) {
            Character cFromString = input.charAt(i);
            Integer count = map.get(cFromString);
            if (count == null)
                count = 0;
            map.put(cFromString, ++count);
        }
        Optional<Map.Entry<Character, Integer>> opt = map.entrySet().stream()
                .filter(i -> i.getValue() == 1).findFirst();

        if (opt.isPresent()) {
            return opt.get().getKey();
        }

        return null;
    }

}

