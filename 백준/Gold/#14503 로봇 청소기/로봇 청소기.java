import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /**
     * 벽 : 1
     * 청소 안한 빈칸 : 0
     * 청소 한 빈칸 : -1
     */
    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int n, m, result = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(new State(sx, sy, dir));
        System.out.println(result);
    }

    private static void dfs(State start) {
        int x = start.x;
        int y = start.y;
        int dir = start.dir;
        map[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 1 || map[nx][ny] == -1) continue;
            result++;
            dfs(new State(nx, ny, dir));
            return;
        }

        int b = (dir + 2) % 4;
        int bx = x + dx[b];
        int by = y + dy[b];
        if (bx >= 0 && by >= 0 && bx < n && by < m && map[bx][by] != 1) {
            dfs(new State(bx, by, dir));
        }
    }

    public static class State {
        int x;
        int y;
        int dir;

        public State(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}