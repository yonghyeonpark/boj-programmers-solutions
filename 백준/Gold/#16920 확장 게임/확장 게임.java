import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n, m, p;
    private static String[][] map;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[] count;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        map = new String[n][m];
        result = new int[p + 1];

        st = new StringTokenizer(br.readLine());
        count = new int[p + 1];
        for (int i = 1; i <= p; i++) {
            int c = Integer.parseInt(st.nextToken());
            if (c > n && c > m) {
                count[i] = Math.max(n, m);
                continue;
            }
            count[i] = c;
        }

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = String.valueOf(line.charAt(j));
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals("#") || map[i][j].equals(".")) continue;
                int castle = Integer.parseInt(map[i][j]);
                result[castle]++;
            }
        }

        for (int i = 1; i <= p; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static void bfs() {
        Queue<Point>[] qs = new Queue[p + 1];
        for (int i = 0; i <= p; i++) {
            qs[i] = new LinkedList<>();
        }

        for (int k = 1; k <= p; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j].equals(String.valueOf(k))) qs[k].offer(new Point(i, j));
                }
            }
        }

        int player = 1;
        int endCheck = 0;
        while (true) {
            int c = count[player];
            Queue<Point> q = qs[player];

            for (int i = 0; i < c; i++) {
                int size = q.size();

                if (size == 0) {
                    endCheck++;
                    break;
                }

                for (int j = 0; j < size; j++) {
                    Point cur = q.poll();
                    int x = cur.x;
                    int y = cur.y;

                    for (int k = 0; k < 4; k++) {
                        int nx = dx[k] + x;
                        int ny = dy[k] + y;

                        if (nx < 0 || ny < 0 || nx >= n || ny >= m || !map[nx][ny].equals(".")) continue;
                        q.offer(new Point(nx, ny));
                        map[nx][ny] = String.valueOf(player);
                    }
                }
            }

            player++;
            if (player > p) {
                if (endCheck == p) {
                    return;
                }
                player = 1;
                endCheck = 0;
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