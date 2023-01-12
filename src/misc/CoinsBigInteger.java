package demo.coins;

import java.math.BigInteger;

public class CoinsBigInteger {
    public static void main(String[] args) {
        Long l = 1L;
        BigInteger sum = new BigInteger("1");
        for (int day=1;day<64; day++){
            System.out.printf("%d: %d%n", day, l);
            l *=2;
            sum.add(BigInteger.valueOf(l));
        }
        System.out.println(sum);
    }
}
//30 mlrd
