import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Timus1322 {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner();
        int n = input.nextInt();
        char[] s = input.next().toCharArray();
        n--;

        Pair[] inv = new Pair[s.length];
        for (int i = 0; i < s.length; i++) {
            inv[i] = new Pair(i, s[i]);
        }
        Arrays.sort(inv, new Comparator<Pair>() {
            @Override
            public int compare(Pair x1, Pair x2) {
                return Character.compare(x1.second, x2.second);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            n = inv[n].first;
            sb.append(s[n]);
        }
        System.out.println(sb);
    }
}
class Pair {
    public int first;
    public char second;

    public Pair(int first, char second) {
        this.first = first;
        this.second = second;
    }
}

class FastScanner {
    BufferedReader br;
    String[] tokens;
    int pointer;

    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
        tokens = new String[0];
        pointer = 0;
    }

    public String next() throws IOException {
        while (pointer >= tokens.length) {
            tokens = br.readLine().split("[\\s]+");
            pointer = 0;
        }
        return tokens[pointer++];
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}