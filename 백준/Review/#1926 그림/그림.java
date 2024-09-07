import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static boolean[][] v;
    private static int n, m;
    private static int area = 0;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        v = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j] && map[i][j] != 0) {
                    bfs(new State(i, j));
                    result++;
                }
            }
        }

        System.out.println(result);
        System.out.println(area);
    }

    private static void bfs(State start) {
        Queue<State> q = new LinkedList<>();
        q.offer(start);
        v[start.x][start.y] = true;
        
        int count = 1;
        while (!q.isEmpty()) {
            State cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 0 || v[nx][ny]) continue;
                q.offer(new State(nx, ny));
                v[nx][ny] = true;
                count++;
            }
        }
        area = Math.max(area, count);
    }

    private static class State {
        int x;
        int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}