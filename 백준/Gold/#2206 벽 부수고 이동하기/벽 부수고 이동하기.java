import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static int[][] map;
    private static boolean[][][] check;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        check = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = chars[j] - '0';
            }
        }

        bfs(new State(0, 0, 1, 1));

        if (!check[n - 1][m - 1][0] && !check[n - 1][m - 1][1]) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }

    private static void bfs(State start) {
        Queue<State> q = new LinkedList<>();
        q.offer(start);
        check[start.x][start.y][start.crush] = true;

        while (!q.isEmpty()) {
            State now = q.poll();
            int x = now.x;
            int y = now.y;
            int move = now.move;
            int crush = now.crush;

            if (x == n - 1 && y == m - 1) {
                result = Math.min(result, move);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || check[nx][ny][crush]) continue;
                if (map[nx][ny] == 1) {
                    if (crush == 1) {
                        q.offer(new State(nx, ny, move + 1, 0));
                        check[nx][ny][0] = true;
                    }
                    continue;
                }
                q.offer(new State(nx, ny, move + 1, crush));
                check[nx][ny][crush] = true;
            }
        }
    }

    private static class State {
        int x;
        int y;
        int move;
        int crush;

        public State(int x, int y, int move, int crush) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.crush = crush;
        }
    }
}
