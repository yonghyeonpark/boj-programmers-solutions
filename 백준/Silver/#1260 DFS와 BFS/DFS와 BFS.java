import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        v = new boolean[n + 1];

        // 정점 연결
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 각 정점에 연결돼있는 점들의 크기 오름차순 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }
        dfs(s);
        System.out.println();
        v = new boolean[n + 1];
        bfs(s);
    }

    private static void dfs(int num) {
        System.out.print(num + " ");
        v[num] = true;

        for (int i = 0; i < graph.get(num).size(); i++) {
            int next = graph.get(num).get(i);
            if (!v[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        v[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int num = q.poll();
            System.out.print(num + " ");
            for (int i = 0; i < graph.get(num).size(); i++) {
                int next = graph.get(num).get(i);
                if (!v[next]) {
                    q.offer(next);
                    v[next] = true;
                }
            }
        }
    }
}
