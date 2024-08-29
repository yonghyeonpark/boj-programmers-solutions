import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static boolean[][] v;
    private static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] dc = {1, -1, 2, -2, 2, -2, 1, -1};
    private static int n, er, ec;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            v = new boolean[n][n];

            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            er = Integer.parseInt(st.nextToken());
            ec = Integer.parseInt(st.nextToken());

            System.out.println(bfs(new State(sr, sc, 0)));
        }
    }

    private static int bfs(State start) {
        Queue<State> q = new LinkedList<>();
        q.offer(start);
        v[start.r][start.c] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int count = cur.count;

            if (r == er && c == ec) return count;

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n || v[nr][nc]) continue;
                q.offer(new State(nr, nc, count + 1));
                v[nr][nc] = true;
            }
        }
        return 0;
    }

    private static class State {
        int r;
        int c;
        int count;

        public State(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
}
