import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int total, start, end, up, down;
    private static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        total = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        up = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());
        v = new boolean[total + 1];
        
        bfs(new State(start, 0));
    }

    private static void bfs(State start) {
        Queue<State> q = new LinkedList<>();
        q.offer(start);
        v[start.x] = true;

        while (!q.isEmpty()) {
            State now = q.poll();
            int nu = now.x + up;
            int nd = now.x - down;
            int count = now.count;

            if (now.x == end) {
                System.out.println(count);
                return;
            }

            if (nu > 0 && nu <= total && !v[nu]) {
                q.offer(new State(nu, count + 1));
                v[nu] = true;
            }
            if (nd > 0 && nd <= total && !v[nd]) {
                q.offer(new State(nd, count + 1));
                v[nd] = true;
            }
        }
        System.out.println("use the stairs ");
    }

    private static class State {
        int x;
        int count;

        public State(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
}