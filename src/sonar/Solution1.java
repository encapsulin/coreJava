package demo.sonar;

// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Solution1 {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.print(i + ": ");
//            System.out.println(int2bin(i));
//        }
        long l1 = System.currentTimeMillis();
        String str = randomString(1000_000_0);
        //System.out.println(str);
        long l2 = System.currentTimeMillis();
        System.out.printf("randomString l2-l1: %d %n",(l2-l1));

//        l1 = System.currentTimeMillis();
//        System.out.println(count1(str));
//        l2 = System.currentTimeMillis();
//        System.out.printf("count1 l2-l1: %d %n",(l2-l1));

        l1 = System.currentTimeMillis();
        System.out.println(count2(str));
        l2 = System.currentTimeMillis();
        System.out.printf("count2(str): %d ms %n",(l2-l1));

        // java.lang.OutOfMemoryError: Java heap space
        // var list = new ArrayList<String>(str.length());
        String[] strArray = new String[str.length()];
        for (int i=0; i<str.length();i++) {
            strArray[i] = str.substring(i,i+1);
        }
        l1 = System.currentTimeMillis();
        System.out.println(count4(strArray));
        l2 = System.currentTimeMillis();
        System.out.printf("count4(strArray): %d ms %n",(l2-l1));
    }

    public int solution(int A, int B) {
        String str = int2bin(A * B);

        return count1(str);
    }

    static String int2bin(int I) {
        StringBuilder sb = new StringBuilder();

        while (I >= 2) {
            int iDiv = I / 2;
            int iRem = I - iDiv * 2;
            I /= 2;
            sb.append(iRem);
        }

        sb.append(I);
        return sb.reverse().toString();
    }

    static int count1(String str) {
        int i = 0;
        for (String s : str.split("")) {
            if (s.equals("1"))
                i++;
        }
        return i;
    }

    static int count2(String str) {
        int cnt = 0;
        for (int i=0; i<str.length();i++) {
            if (str.charAt(i) == '1')
                cnt++;
        }
        return cnt;
    }

    static String randomString(int len){
        StringBuilder sb = new StringBuilder(len);
        Random rnd = new Random();
        for(int i=0;  i< len; i++){
            sb.append(rnd.nextInt(10)%2);
        }
        return sb.toString();
    }

    static int count3(ArrayList<String> list) {
        int cnt = 0;

        for (int i=0; i< list.size();i++) {
            if (list.get(i).equals("1"))
                cnt++;
        }
        return cnt;
    }
    static int count4(String[] strArray) {
        int cnt = 0;

        for (int i=0; i< strArray.length;i++) {
            if (strArray[i].equals("1"))
                cnt++;
        }
        return cnt;
    }

}
