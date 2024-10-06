import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n, m, h;
    private static int[][][] storage;
    private static boolean[][][] v;
    private static int[] dx = {0, 0, 1, -1, 0, 0};
    private static int[] dy = {1, -1, 0, 0, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};
    private static List<Point> ripens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        storage = new int[h][n][m];
        v = new boolean[h][n][m];

        ripens = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    storage[i][j][k] = tomato;
                    if (tomato == 1) ripens.add(new Point(j, k, i));
                }
            }
        }

        System.out.println(bfs());
    }

    // 1 : 익은 토마토
    // 0 : 익지 않은 토마토
    // -1 : 빈칸
    private static int bfs() {
        Queue<Point> q = new LinkedList<>();
        for (Point ripen : ripens) {
            q.offer(ripen);
            v[ripen.z][ripen.x][ripen.y] = true;
        }

        int day = 0;
        while (!q.isEmpty()) {
            if (isAllRipen()) {
                return day;
            }

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point cur = q.poll();
                int x = cur.x;
                int y = cur.y;
                int z = cur.z;

                for (int j = 0; j < 6; j++) {
                    int nx = dx[j] + x;
                    int ny = dy[j] + y;
                    int nz = dz[j] + z;

                    if (nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= h) continue;
                    if (v[nz][nx][ny] || storage[nz][nx][ny] == -1) continue;
                    q.offer(new Point(nx, ny, nz));
                    storage[nz][nx][ny] = 1;
                    v[nz][nx][ny] = true;
                }
            }
            day++;
        }
        return -1;
    }

    private static boolean isAllRipen() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (storage[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }

    private static class Point {
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}