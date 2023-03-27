import java.util.*;

public class Timus1726{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        long[] x = new long[(int) n];
        long[] y = new long[(int) n];
        for (int i = 0; i < n; i++) {
            x[i] = input.nextLong();
            y[i] = input.nextLong();
        }
        Arrays.sort(x);
        Arrays.sort(y);
        long s = 0;
        for (int i = 0; i < n; i++) {
            s += (long)x[i]*i - (long)x[i]*(n-i-1);
            s += (long)y[i]*i - (long)y[i]*(n-i-1);
        }
        System.out.println(s/(n*(n-1)/2));
    }
}
