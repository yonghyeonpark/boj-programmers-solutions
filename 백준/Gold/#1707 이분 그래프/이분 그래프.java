import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<List<Integer>> graph;
    private static int[] state;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            graph = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            state = new int[n + 1];
            String result = "YES";
            for (int j = 1; j <= n; j++) {
                if (state[j] != 0) continue;
                if (!bfs(j)) {
                    result = "NO";
                    break;
                }
            }
            System.out.println(result);
        }
    }

    /*
     * 쭉 순회하면서 다른 번호 지정
     * 번호가 지정 돼있으면 현재 번호와 비교
     */
    private static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        state[start] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            List<Integer> edge = graph.get(cur);
            int size = edge.size();
            for (int i = 0; i < size; i++) {
                int next = edge.get(i);
                if (state[next] != 0) {
                    if (state[cur] == state[next]) return false;
                    continue;
                }
                q.offer(next);
                state[next] = -state[cur];
            }
        }
        return true;
    }
}
