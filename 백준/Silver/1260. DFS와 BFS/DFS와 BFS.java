import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        v = new boolean[n+1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (ArrayList<Integer> a : graph) {
            Collections.sort(a);
        }
        dfs(start);
        System.out.println();
        v = new boolean[n+1];
        bfs(start);
    }

    // 스택 or 재귀
    private static void dfs(int x) {
        System.out.print(x + " ");
        v[x] = true;
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!v[y]) {
                dfs(y);
            }
        }
    }

    // 큐
    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        v[start] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!v[y]) {
                    q.offer(y);
                    v[y] = true;
                }
            }
        }
    }
}