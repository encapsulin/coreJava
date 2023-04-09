package misc;

import java.util.*;

public class CombiTest42mins {

    static Set<String> setString;

    public static void main(String[] args) {
        setString = new LinkedHashSet<String>();
        combi(new String[]{"1", "2"});
        System.out.println(setString);

        setString = new LinkedHashSet<String>();
        combi(new String[]{"1", "2", "3"});
        System.out.println(setString);

        setString = new LinkedHashSet<String>();
        combi(new String[]{"1", "2", "3", "4"});
        System.out.println(setString);
        System.out.println(setString.size());
    }

    private static void combi(String[] strings) {
        boolean bHasNew = false;
        System.out.println(Arrays.asList(strings));
//        System.out.println(Arrays.toString(strings));

        var list = new ArrayList<String>(Arrays.asList(strings));
        for (String s : list) {
            var listTmp = new ArrayList<String>(list);
            listTmp.remove(s);
            int i = 0;
            int cnt = listTmp.size();
            do {
                listTmp.add(i, s);
                String sCombi = String.join("", listTmp);
                //System.out.println(sCombi);
                if(setString.add(sCombi)) {
                    bHasNew = true;
                    combi(listTmp.toArray(new String[0]));
                }
                listTmp.remove(i);
            } while (i++ < cnt);
        }

    }
}
/*
in: [a, b, c]
copy [a b c]
remove a from copy [b c]

 out: []
*/