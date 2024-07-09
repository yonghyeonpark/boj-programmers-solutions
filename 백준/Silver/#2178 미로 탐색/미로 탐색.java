import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static int n, m;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] ca = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(ca[j]);
            }
        }
        bfs(new State(0, 0, 1));
        System.out.println(min);
    }

    private static void bfs(State start) {
        Queue<State> q = new LinkedList<>();
        q.offer(start);
        map[start.x][start.y] = 0;
        
        while (!q.isEmpty()) {
            State next = q.poll();
            int x = next.x;
            int y = next.y;
            int move = next.move;
            if (x == n - 1 && y == m - 1) {
                min = Math.min(min, move);
            }
            // map[x][y] = 0; => 이 위치에서 방문처리를 하면 큐에 데이터가 중복으로 추가됨

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 0) {
                    continue;
                }
                q.offer(new State(nx, ny, move + 1));
                map[nx][ny] = 0; // 데이터의 추가와 방문 체크를 같이 진행해야 함
            }
        }
    }

    // 시간 초과
    private static void dfs(State s) {
        int x = s.x;
        int y = s.y;
        int move = s.move;
        if (x == n - 1 && y == m - 1) {
            min = Math.min(min, move);
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 0) {
                continue;
            }
            map[x][y] = 0;
            dfs(new State(nx, ny, move + 1));
            map[x][y] = 1;
        }
    }

    private static class State {
        int x;
        int y;
        int move;

        public State(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
}
