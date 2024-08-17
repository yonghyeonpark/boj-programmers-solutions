import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<List<Integer>> relationships = new ArrayList<>();
    private static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        v = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            relationships.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relationships.get(a).add(b);
            relationships.get(b).add(a);
        }

        System.out.println(bfs(new State(1, 0)));
    }

    private static int bfs(State start) {
        Queue<State> q = new LinkedList<>();
        q.offer(start);
        v[start.num] = true;

        int result = 0;
        while (!q.isEmpty()) {
            State now = q.poll();
            int num = now.num;
            int count = now.count;

            if (count == 2) {
                continue;
            }
            for (int i = 0; i < relationships.get(num).size(); i++) {
                int next = relationships.get(num).get(i);
                if (v[next]) continue;
                q.offer(new State(next, count + 1));
                v[next] = true;
                result++;
            }
        }
        return result;
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