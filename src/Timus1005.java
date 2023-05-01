//https://acm.timus.ru/problem.aspx?space=1&num=1005 - task



import java.util.*;

public class Timus1005
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] stack = new int[n];
        for (int i = 0; i < n; i++) {
            stack[i] = in.nextInt();
        }
        if (n == 1) {
            System.out.println(stack[0]);
        } else {
            System.out.println(SortedBit(stack));
        }
    }
        static int SortedBit (int[] stack){
            final int N = stack.length;
            final int LIMIT = 1 << N - 1;
            int diff = Integer.MAX_VALUE;
            for (int i = 0; i <= LIMIT; i++) {
                int sum1 = 0, sum2 = 0;
                int k = i;
                for (int j = 0; j < N; j++) {
                    if ((k & 0x1) == 0) sum1 += stack[j];
                    else sum2 += stack[j];
                    k = k >> 1;
                }
                int ans = (sum1 >= sum2) ? sum1 - sum2 : sum2 - sum1;
                if (ans < diff) diff = ans;
            }
            return diff;
        }
    }
