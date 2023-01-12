package demo.sonar;

import java.util.Random;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println("-=start=-");

        int[] A = new int[]{1, 3, -3};
//        System.out.println(solution(A));


        final int iMax = 1_000_000_00;
        int[] B = new int[iMax];
        for(int i=0; i<iMax;i++){
            Random r = new Random();
            B[i] = r.nextInt();
        }
        long l1 = System.currentTimeMillis();
        System.out.println(solution(B));
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);

        System.out.println("-=stop=-");
    }

    public static int solution(int[] A) {
        System.out.println("solution()");
//        System.out.println(Arrays.toString(A));
        int iMax = Integer.MIN_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            int iDiff = A[i] - A[i+1];
            if(iMax < iDiff){
                iMax = iDiff;
            }
        }
        return iMax;
    }
}