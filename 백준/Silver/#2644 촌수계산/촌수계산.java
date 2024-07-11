import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] v;
    private static int a, b, result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        v = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        dfs(a, 0);
        System.out.println(result);
    }

    private static void dfs(int n, int count) {
        if (n == b) {
            result = count;
        }
        v[n] = true;
        for (int i = 0; i < graph.get(n).size(); i++) {
            int next = graph.get(n).get(i);
            if (!v[next]) {
                dfs(next, count + 1);
            }
        }
    }
}