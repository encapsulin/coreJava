//package speedCalc;

import java.lang.Math;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

public class TestSin {

    public static void main(String args[]) {
       int calcs = 0;
	   int count = 10;
	   int i = 0;
	   while(i++ < count)
		  calcs += calc();

	   System.out.printf("%n total calcs per %d sec: ", count);
            printFormat(calcs);

	   System.out.printf("%n averg calcs per 1 sec: ");
            printFormat(calcs/count);        

	   System.out.println();
    }

    static int calc(){
        double dSin = 0;
        long t1 = System.currentTimeMillis();
        int count = 0;
        Random rnd = new Random();

        while (System.currentTimeMillis() - t1 < 1000) {
            double a = rnd.nextInt(180);
            double r = Math.toRadians(a);
            dSin += Math.sin(r);
            count++;
        }
        System.out.printf("%n (ignore %f) ",dSin);
    	System.out.printf(" calcs/sec: ");
	    printFormat(count);
        return count;
    }

    static void printFormat(long l){
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);
        System.out.print(formatter.format(l));
    }

}
