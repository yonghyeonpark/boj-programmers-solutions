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
    private static int[] dx = {0, 0, 0, 1, -1};
    private static int[] dy = {0, 1, -1, 0, 0};
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
        q.offer(new State(0, 0, k, 1, true));
        v[0][0][k] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int crush = cur.crush;
            int move = cur.move;
            boolean isDay = cur.isDay;

            if (x == n - 1 && y == m - 1) {
                result = move;
                return;
            }

            for (int i = 0; i < 5; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 제자리이기 때문에 방문 검증 x
                // 벽을 부술 수 없으면 머무는 의미가 없음
                // 낮에는 벽을 부술 수 있으므로 머무는 의미가 없음
                if (i == 0 && crush > 0 && !isDay) {
                    q.offer(new State(nx, ny, crush, move + 1, !isDay));
                    continue;
                }
                
                // 벽을 부술 수 있는지와 낮인지를 같이 판단
                if (map[nx][ny] == 1 && crush > 0 && !v[nx][ny][crush - 1] && isDay) {
                    q.offer(new State(nx, ny, crush - 1, move + 1, !isDay));
                    v[nx][ny][crush - 1] = true;
                }
                
                if (map[nx][ny] == 0 && !v[nx][ny][crush]) {
                    q.offer(new State(nx, ny, crush, move + 1, !isDay));
                    v[nx][ny][crush] = true;
                }
            }
        }
    }

    private static class State {
        int x;
        int y;
        int crush;
        int move;
        boolean isDay;

        public State(int x, int y, int crush, int move, boolean isDay) {
            this.x = x;
            this.y = y;
            this.crush = crush;
            this.move = move;
            this.isDay = isDay;
        }
    }
}