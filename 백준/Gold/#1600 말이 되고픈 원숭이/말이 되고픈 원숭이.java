import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static int n, m;
    private static boolean[][][] v;
    private static int[] dr = {0, 0, 1, -1};
    private static int[] dc = {1, -1, 0, 0};
    private static int[] dr2 = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] dc2 = {1, -1, 2, -2, 2, -2, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        v = new boolean[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(new State(0, 0, k, 0)));
    }

    private static int bfs(State start) {
        Queue<State> q = new LinkedList<>();
        q.offer(start);
        v[start.r][start.c][start.jump] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int jump = cur.jump;
            int count = cur.count;

            if (r == n - 1 && c == m - 1) {
                return count;
            }

            // 원숭이의 이동 방법
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] == 1 || v[nr][nc][jump]) continue;
                q.offer(new State(nr, nc, jump, count + 1));
                v[nr][nc][jump] = true;
            }

            // 말의 이동 방법
            if (jump == 0) continue;
            for (int i = 0; i < 8; i++) {
                int nr = r + dr2[i];
                int nc = c + dc2[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] == 1 || v[nr][nc][jump - 1]) continue;
                q.offer(new State(nr, nc, jump - 1, count + 1));
                v[nr][nc][jump - 1] = true;
            }
        }
        return -1;
    }

    private static class State {
        int r;
        int c;
        int jump;
        int count;

        public State(int r, int c, int jump, int count) {
            this.r = r;
            this.c = c;
            this.jump = jump;
            this.count = count;
        }
    }
}
