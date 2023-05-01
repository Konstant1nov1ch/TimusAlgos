import java.util.Scanner;

public class Timus1494 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] st = new int[n+1];
        int top = 0;
        int now = 1;
        boolean isProof = true;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            while (st[top] != a && now <= n) {
                st[++top] = now++;
            }
            if (st[top] == a && top > 0) {
                top--;
            } else {
                isProof = false;
                break;
            }
        }
        System.out.println(isProof ? "Not a proof" : "Cheater");
    }
}
