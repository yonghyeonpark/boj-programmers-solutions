import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] v;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        v = new boolean[n + 1];
        result = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(1);
        
        for (int i = 2; i <= n; i++) {
            System.out.println(result[i]);
        }
    }

    private static void dfs(int node) {
        v[node] = true;
        int s = graph.get(node).size();
        for (int i = 0; i < s; i++) {
            int c = graph.get(node).get(i);
            if (!v[c]) {
                result[c] = node;
                dfs(c);
            }
        }
    }
}