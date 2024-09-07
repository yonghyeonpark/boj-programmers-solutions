import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static boolean[][] v;
    private static int n;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int max = Integer.MIN_VALUE;
    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int h = Integer.parseInt(st.nextToken());
                map[i][j] = h;
                max = Math.max(max, h);
            }
        }

        for (int i = 0; i < max; i++) {
            v = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] <= i) v[j][k] = true;
                }
            }

            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!v[j][k]) {
                        bfs(new Point(j, k));
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
        }

        System.out.println(result);
    }

    private static void bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        v[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || v[nx][ny]) continue;
                q.offer(new Point(nx, ny));
                v[nx][ny] = true;
            }
        }
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}