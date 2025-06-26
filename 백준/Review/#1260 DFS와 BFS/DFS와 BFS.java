import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static boolean[] visit;
    private static List<List<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n, m, v;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a);
        }
        for (List<Integer> list : map) {
            list.sort(null);
        }

        visit = new boolean[n + 1];
        dfs(v);
        System.out.println();
        visit = new boolean[n + 1];
        bfs(v);
    }

    private static void dfs(int num) {
        System.out.print(num + " ");
        visit[num] = true;

        List<Integer> list = map.get(num);
        int length = list.size();
        for (int i = 0; i < length; i++) {
            int next = list.get(i);
            if (visit[next]) continue;
            visit[next] = true;
            dfs(next);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");

            List<Integer> list = map.get(cur);
            int length = list.size();
            for (int i = 0; i < length; i++) {
                int next = list.get(i);
                if (visit[next]) continue;
                q.offer(next);
                visit[next] = true;
            }
        }
    }
}