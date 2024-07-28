import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static int[][] map;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int count = 0;
    private static int maxArea = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        boolean isCheckAllZero = false;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    isCheckAllZero = true;
                }
                map[i][j] = num;
            }
        }

        if (!isCheckAllZero) {
            System.out.println(0 + "\n" + 0);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1 || map[i][j] == 0) continue;
                bfs(new Point(i, j));
                count++;
            }
        }
        System.out.println(count + "\n" + maxArea);
    }

    private static void bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        map[start.x][start.y] = -1;

        int area = 1;
        while (!q.isEmpty()) {
            Point now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == -1 || map[nx][ny] == 0) continue;
                q.offer(new Point(nx, ny));
                map[nx][ny] = -1;
                area++;
            }
        }
        maxArea = Math.max(maxArea, area);
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