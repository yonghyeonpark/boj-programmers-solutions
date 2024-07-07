import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        v = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!v[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.print(count);
    }

    private static void dfs(int a) {
        v[a] = true;
        for (int i = 0; i < graph.get(a).size(); i++) {
            int b = graph.get(a).get(i);
            if (!v[b]) {
                dfs(b);
            }
        }
    }
}