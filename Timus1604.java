import java.util.*;

public class Timus1604 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        PriorityQueue<Pair> q = new PriorityQueue<>(new Compare());
        for (int i = 1; i <= n; i++) {
            int x = input.nextInt();
            q.offer(new Pair(x, i));
        }
        while (!q.isEmpty()) {
            Pair p1 = q.poll();
            System.out.print(p1.second + " ");
            if (!q.isEmpty()) {
                Pair p2 = q.poll();
                System.out.print(p2.second + " ");
                if (p2.first > 1) {
                    q.offer(new Pair(p2.first - 1, p2.second));
                }
            }
            if (p1.first > 1) {
                q.offer(new Pair(p1.first - 1, p1.second));
            }
        }
    }

    public static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static class Compare implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            if (a.first == b.first) {
                return a.second - b.second;
            } else {
                return b.first - a.first;
            }
        }
    }
}
