import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n, k, range, result = 0;
    private static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        range = 2 * Math.max(n, k);
        v = new boolean[range + 1];

        bfs(new State(n, 0));
        System.out.println(result);
    }

    private static void bfs(State start) {
        Queue<State> q = new LinkedList<>();
        v[start.x] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            State cur = q.poll();
            int x = cur.x;
            int time = cur.time;
            if (x == k) {
                result = time;
                break;
            }
            
            int a = x + 1;
            int b = x - 1;
            int c = x * 2;

            if (a <= range && !v[a]) {
                v[a] = true;
                q.offer(new State(a, time + 1));
            }
            if (b >= 0 && !v[b]) {
                v[b] = true;
                q.offer(new State(b, time + 1));
            }
            if (c != 0 && c <= range && !v[c]) {
                v[c] = true;
                q.offer(new State(c, time + 1));
            }
        }
    }

    private static class State {
        int x;
        int time;

        public State(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}