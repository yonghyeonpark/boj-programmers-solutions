import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n, m, k;
    private static int[][] map;
    private static boolean[][][] v;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        v = new boolean[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        bfs();

        System.out.println(result);
    }

    private static void bfs() {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(0, 0, k, 1));
        v[0][0][k] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int s = cur.s;
            int count = cur.count;

            if (x == n - 1 && y == m - 1) {
                result = count;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                // 벽이 존재
                // 부술 수 있는 횟수가 남아 있음
                if (map[nx][ny] == 1 && s > 0 && !v[nx][ny][s - 1]) {
                    q.offer(new State(nx, ny, s - 1, count + 1));
                    v[nx][ny][s - 1] = true;
                }
                if (map[nx][ny] == 0 && !v[nx][ny][s]) {
                    q.offer(new State(nx, ny, s, count + 1));
                    v[nx][ny][s] = true;
                }
            }
        }
    }

    private static class State {
        int x;
        int y;
        int s;
        int count;

        public State(int x, int y, int s, int count) {
            this.x = x;
            this.y = y;
            this.s = s;
            this.count = count;
        }
    }
}