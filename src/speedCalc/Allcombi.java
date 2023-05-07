package speedCalc;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Allcombi {

    static long list_size = 0;
    static List<String> list = new ArrayList<>();
    static Long t1 = System.currentTimeMillis();

    public static void main(String[] args) {
        long result_sum = 0;
        DecimalFormat df = new DecimalFormat("###,###,###");

        int count = 10;

        for(int i=0; i< count; i++) {
            long result = main1();
            System.out.printf("\n list_size: %s",df.format(result));
            result_sum += result;
        }

        System.out.printf("\n avg: %s",df.format(result_sum/count));
    }

    public static long main1() {
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
return list_size;
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
