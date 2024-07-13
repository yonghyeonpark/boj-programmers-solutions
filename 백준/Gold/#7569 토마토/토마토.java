import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][][] container;
    private static int[] dx = {1, -1, 0, 0, 0, 0};
    private static int[] dy = {0, 0, 1, -1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};
    private static int m, n, h, count = 0;
    private static Queue<State> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        container = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    container[i][j][k] = num;
                    if (num == 1) {
                        q.offer(new State(j, k, i, 0));
                    }
                }
            }
        }
        
        if (q.size() == m * n * h) {
            System.out.println(0);
        } else {
            bfs();
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        if (container[i][j][k] == 0) {
                            count = -1;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void bfs() {
        count = 0;
        while (!q.isEmpty()) {
            State s = q.poll();
            int x = s.x;
            int y = s.y;
            int z = s.z;
            int now = s.count;

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= h || container[nz][nx][ny] == -1 || container[nz][nx][ny] == 1) {
                    continue;
                }
                q.offer(new State(nx, ny, nz, now + 1));
                container[nz][nx][ny] = 1;
                count = now + 1;
            }
        }
    }

    private static class State {
        
        int x;
        int y;
        int z;
        int count;

        public State(int x, int y, int z, int count) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }
}
