import java.util.*;

public class Timus1521 {
    static int[] node = new int[100010<<2];
    static int ans = 0;

    public static void pushup(int tr) {
        node[tr] = node[tr<<1|1] + node[tr<<1];
    }

    public static void build(int l, int r, int tr) {
        node[tr] = r-l+1;
        if(l == r) return;
        int mid = (l+r) >> 1;
        build(l, mid, tr<<1);
        build(mid+1, r, tr<<1|1);
    }

    public static int getsum(int L, int R, int l, int r, int tr) {
        if(L <= l && R >= r) {
            return node[tr];
        }
        int mid = (l+r) >> 1;
        int ans = 0;
        if(L <= mid) ans += getsum(L, R, l, mid, tr<<1);
        if(R > mid) ans += getsum(L, R, mid+1, r, tr<<1|1);
        return ans;
    }

    public static void remove(int pos, int l, int r, int tr) {
        if(l == r) {
            node[tr] = 0;
            ans = l;
            return;
        }
        int mid = (l+r) >> 1;
        if(pos <= node[tr<<1]) {
            remove(pos, l, mid, tr<<1);
        } else {
            remove(pos-node[tr<<1], mid+1, r, tr<<1|1);
        }
        pushup(tr);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            ans = 0;
            build(1, n, 1);
            for(int i = 0; i < n; i++) {
                int k;
                if(ans == 0) {
                    k = m % node[1];
                } else {
                    int ssum = getsum(1, ans, 1, n, 1);
                    k = (ssum + m) % node[1];
                }
                if(k == 0) k = node[1];
                remove(k, 1, n, 1);
                if(i > 0) {
                    System.out.print(" ");
                }
                System.out.print(ans);
            }
            System.out.println();
        }
    }
}
