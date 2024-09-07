import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static boolean[] v;
    private static int total, s, e, u, d;
    private static int[] move;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        total = Integer.parseInt(st.nextToken());
        v = new boolean[total + 1];

        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        move = new int[2];
        move[0] = Integer.parseInt(st.nextToken());
        move[1] = -Integer.parseInt(st.nextToken());

        if (s == e) {
            System.out.println(0);
            return;
        }

        bfs();

        if (result == 0) {
            System.out.println("use the stairs");
            return;
        }
        System.out.println(result);
    }

    private static void bfs() {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(s, 0));
        v[s] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            int f = cur.f;
            int count = cur.count;

            if (f == e) {
                result = count;
                return;
            }

            for (int i = 0; i < 2; i++) {
                int next = f + move[i];

                if (next < 1 || next > total || v[next]) continue;
                q.offer(new State(next, count + 1));
                v[next] = true;
            }
        }
    }

    private static class State {
        int f;
        int count;

        public State(int f, int count) {
            this.f = f;
            this.count = count;
        }
    }
}
