import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(Kata.nextBiggerNumber(2017));
    }

    public class Kata {
        public static long nextBiggerNumber(long n) {
            if (n < 10) {
                return -1;
            }
            String temp = Long.toString(n);
            List<Long> list = new ArrayList<>();
            long[] asd = new long[temp.length()];
            long[] asd3 = new long[temp.length()];
            for (int i = 0; i < asd.length; i++) {
                asd[i] = temp.charAt(i) - '0';
                asd3[i] = temp.charAt(i) - '0';
            }
            StringBuilder str2 = new StringBuilder();
            StringBuilder str = new StringBuilder();
            long c = asd.length -1;
            long temp2 = 0;
            for (int i = asd.length -1 ; i > 0; i--) {
                list.add(asd[i]);
                c--;
                if (asd[i] > asd[i - 1]) {
                    temp2 = asd[i];
                    asd[i] = asd[i - 1];
                    asd[i - 1] = temp2;
                    break;
                }
            }
            long temp4 = 0;
            long[] asd2 = new long[list.size()];
            for (int i = 0; i < asd2.length; i++) {
                asd2[i] = list.get(i);
            }
            Arrays.sort(asd2);
            for (int j = 0; j < asd2.length; j++) {
                if (asd3[(int) c] < asd2[j]){
                    temp4 = asd3[(int) c];
                    asd3[(int) c] = asd2[j];
                    asd2[j] = temp4;
                    break;
                }
            }
            Arrays.sort(asd2);
            int f= 0;
            for (int i = (int) (c+1); i < asd3.length; i++) {
                asd3[i] = asd2[f++];
            }
            for(long as:asd) {
                str2.append(as);
            }
            for (long as:asd3) {
                str.append(as);
            }
            long e = Long.parseLong(str2.toString());
            long d = Long.parseLong(str.toString());
            if(e==n) {
                return -1;
            }
            return d;
        }
    }
}