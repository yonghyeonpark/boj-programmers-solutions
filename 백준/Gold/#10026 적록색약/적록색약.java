import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static char[][] map;
    private static char[][] mapB;
    private static boolean[][] v;
    private static int n;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        mapB = new char[n][n];
        v = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                char color = charArray[j];
                map[i][j] = color;
                if (color == 'G') {
                    mapB[i][j] = 'R';
                } else mapB[i][j] = color;
            }
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (v[i][j]) continue;
                bfs(new Point(i, j));
                result++;
            }
        }
        map = mapB;
        v = new boolean[n][n];
        int resultB = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (v[i][j]) continue;
                bfs(new Point(i, j));
                resultB++;
            }
        }

        System.out.println(result + " " + resultB);
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

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || v[nx][ny] || map[x][y] != map[nx][ny]) continue;
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