import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<List<Integer>> routes = new ArrayList<>();
    private static boolean[] v;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            routes.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            routes.get(a).add(b);
            routes.get(b).add(a);
        }

        result = new int[n + 1];
        v = new boolean[n + 1];
        bfs();

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, result[i]);
        }

        int count = 0;
        int first = 0;
        for (int i = 1; i <= n; i++) {
            if (result[i] == max) {
                if (count == 0) {
                    first = i;
                }
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(first)
                .append(" ")
                .append(max)
                .append(" ")
                .append(count);
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(1, 0));
        v[1] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            int num = cur.num;
            int count = cur.count;
            result[num] = count;

            List<Integer> route = routes.get(num);
            int size = route.size();
            for (int i = 0; i < size; i++) {
                int next = route.get(i);

                if (v[next]) continue;
                q.offer(new State(next, count + 1));
                v[next] = true;
            }
        }
    }

    private static class State {
        int num;
        int count;

        public State(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
