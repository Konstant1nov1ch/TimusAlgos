import java.io.*;

public class Timus1207 implements Runnable {
    private BufferedReader bufferedReader;
    private StreamTokenizer in;
    private PrintWriter out;

    public Timus1207() {
        this(System.in, System.out);
    }

    public Timus1207(InputStream inputStream, OutputStream outputStream) {
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        in = new StreamTokenizer(bufferedReader);
        out = new PrintWriter(new OutputStreamWriter(outputStream));
    }

    public static void main(String[] args) throws IOException {
        new Timus1207().run();
    }

    public void run() {
        try {
            solve();
            out.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private double readNumber() throws IOException {
        int nextToken = in.nextToken();
        if (nextToken == StreamTokenizer.TT_NUMBER) {
            return in.nval;
        }
        throw new IllegalStateException("Number expected. Found: " + nextToken);
    }

    private String readWord() throws IOException {
        int nextToken = in.nextToken();
        if (nextToken == StreamTokenizer.TT_WORD) {
            return in.sval;
        }
        throw new IllegalStateException("Word expected. Found: " + nextToken);
    }

    //TODO global variables

    private void solve() throws Exception {
        int n = (int) readNumber();
        double x0 = readNumber();
        double y0 = readNumber();
        double xs[] = new double[n - 1];
        double ys[] = new double[n - 1];
        double[] a = new double[n - 1];
        int ids[] = new int[n - 1];
        int left = 0;
        int right = 0;
        int current = -1;
        for (int i = 0; i < a.length; i++) {
            xs[i] = readNumber() - x0;
            ys[i] = readNumber() - y0;
            a[i] = Math.atan(ys[i] / xs[i]);
            ids[i] = i;
            if (isLeft(xs[i], ys[i])) {
                left++;
            } else {
                right++;
            }
        }
        for (int i = 1; i < ids.length; i++) {
            int key = ids[i];
            int j = i - 1;
            while (j >= 0 && a[ids[j]] > a[key]) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key;
        }
        while (left != right) {
            if (current >= 0) {
                if (isLeft(xs[ids[current]], ys[ids[current]])) {
                    right++;
                } else {
                    left++;
                }
            }
            current++;
            if (isLeft(xs[ids[current]], ys[ids[current]])) {
                left--;
            } else {
                right--;
            }
        }
        out.print("1 ");
        out.println(ids[current] + 2);
    }

    private boolean isLeft(double x, double y) {
        return x < 0/* || x == 0 && y > 0*/;
    }
}
