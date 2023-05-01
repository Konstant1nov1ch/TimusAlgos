import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Timus1067 {
    BufferedReader in;
    PrintWriter out;

    int nextInt() throws IOException {
        return Integer.parseInt(in.readLine());
    }

    String nextLine() throws IOException {
        return String.valueOf(in.readLine());
    }

    class Node {
        public TreeMap<String, Node> nodes = new TreeMap<>();
    }

    void run() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }

    void solve() throws IOException {
        int N = nextInt();
        StringTokenizer tokens;
        Node root = new Node();

        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(nextLine(), "\\");
            Node currentNode = root;
            Node parent = null;
            String parentName = null;
            while (tokens.hasMoreTokens()) {
                String name = tokens.nextToken();
                if (currentNode == null && parent != null) {
                    currentNode = new Node();
                    parent.nodes.put(parentName, currentNode);
                }
                if (!currentNode.nodes.containsKey(name)) {
                    currentNode.nodes.put(name, null);
                }
                parent = currentNode;
                currentNode = currentNode.nodes.get(name);
                parentName = name;
            }
        }
        printNodes(root, 0);
    }

    void printNodes(Node node, int level) {
        for (Map.Entry<String, Node> kv : node.nodes.entrySet()) {
            for (int i = 0; i < level; i++) {
                out.print(" ");
            }
            out.println(kv.getKey());
            if (kv.getValue() != null) {
                printNodes(kv.getValue(), level + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Timus1067().run();
    }
}
