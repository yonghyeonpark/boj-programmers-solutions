import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        int[][] result = new int[n][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                v = new boolean[n + 1];
                result[i - 1][j - 1] = bfs(i, j);
            }
        }

        for (int[] row : result) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    private static int bfs(int i, int j) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int k = 0; k < graph.get(now).size(); k++) {
                int next = graph.get(now).get(k);

                if (v[next]) continue;
                if (next == j) return 1;
                q.offer(next);
                v[next] = true;
            }
        }
        return 0;
    }
}
