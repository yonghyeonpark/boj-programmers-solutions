import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[][] map;
    private static boolean[][] v;
    private static int islandNum = 2;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int minLength = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬을 구별하는 숫자 부여
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 1) continue;
                divideIsland(new Point(i, j));
                islandNum++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) continue;
                v = new boolean[n][n];
                getMinLength(new State(new Point(i, j), 0));
            }
        }

        System.out.println(minLength);
    }

    private static void divideIsland(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        map[start.x][start.y] = islandNum;

        while (!q.isEmpty()) {
            Point now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] != 1) continue;
                q.offer(new Point(nx, ny));
                map[nx][ny] = islandNum;
            }
        }
    }

    private static void getMinLength(State start) {
        Queue<State> q = new LinkedList<>();
        q.offer(start);
        int islandNum = map[start.point.x][start.point.y];

        while (!q.isEmpty()) {
            State now = q.poll();
            int x = now.point.x;
            int y = now.point.y;
            int count = now.count;

            if (map[x][y] != islandNum && map[x][y] != 0) {
                minLength = Math.min(minLength, count - 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == islandNum || v[nx][ny]) continue;
                q.offer(new State(new Point(nx, ny), count + 1));
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

    private static class State {
        Point point;
        int count;

        public State(Point point, int count) {
            this.point = point;
            this.count = count;
        }
    }
}