import java.util.Scanner;

public class Timus2025 {
    static int fight(int n, int k) {
        int[] arr = new int [k];
        int n1 = n % k;
        int n2 = n / k;
        for (int i = 0; i < n1; i ++) {
            arr[i] = n2 + 1;
        }
        for (int i = n1; i < k; i ++) {
            arr[i] = n2;
        }
        int ans = 0;
        for (int i = 0; i < k - 1; i ++) {
            for (int j = i + 1; j < k; j ++) {
                ans += arr[i] * arr[j];
            }
        }
        return ans;
    }

    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int t, n, k;
        t = in.nextInt();
        int[] ans = new int [t];
        for (int i = 0; i < t; i ++) {
            k = in.nextInt();
            n = in.nextInt();
            ans[i] = fight(k, n);
        }
        in.close();
        for (int i = 0; i < t; i ++) {
            System.out.println(ans[i]);
        }
    }
}
