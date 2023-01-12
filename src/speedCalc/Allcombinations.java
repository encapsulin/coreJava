package speedCalc;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Allcombinations {

    static long list_size = 0;
    static List<String> list = new ArrayList<>();
    static Long t1 = System.currentTimeMillis();

    public static void main(String[] args) {

        for(int i=0; i< 10; i++)
            main1();

    }

    public static void main1() {
        t1 = System.currentTimeMillis();
        list = new ArrayList<>();
        list_size = 0;

        String str = "0123456789";
        int len = 10;

//        System.out.printf("str: %s, len: %d\n", str, len);
//        System.out.printf("\nStart time: %d", t1);

        combs("", str, len);
        Long t2 = System.currentTimeMillis();

//        System.out.println(list);

        DecimalFormat df = new DecimalFormat("###,###,###");
        System.out.printf("\n list_size: %s",df.format(list_size));


//        System.out.printf("\nStop time: %d", t2);
//        System.out.printf("\nExec time: %dms, %ds", t2-t1, (t2-t1)/1000);

    }

    public static void combs(String prefix, String str, int deep) {

        if(deep == 0)
            return;

        if(System.currentTimeMillis() - t1 > 1000)
            return;

        for(Character c: str.toCharArray()){
            //System.out.println(prefix+c);
//            list.add(prefix+c);
            list_size++;
            combs(prefix+c, str, deep-1);
        }

    }
}
