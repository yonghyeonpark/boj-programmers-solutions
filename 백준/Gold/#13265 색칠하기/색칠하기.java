import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<List<Integer>> links;
    private static int[] state;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            links = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for (int j = 0; j <= n; j++) {
                links.add(new ArrayList<>());
            }

            state = new int[n + 1];

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                links.get(x).add(y);
                links.get(y).add(x);
            }

            String result = "possible";
            for (int j = 1; j <= n; j++) {
                if (state[j] != 0) continue;
                if (bfs(j) == 0) {
                    result = "impossible";
                    break;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        state[start] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            List<Integer> curLink = links.get(cur);
            int size = curLink.size();
            for (int i = 0; i < size; i++) {
                int next = curLink.get(i);
                if (state[next] == state[cur]) return 0;
                if (state[next] != 0) continue;
                state[next] = -state[cur];
                q.offer(next);
            }
        }
        return 1;
    }
}
