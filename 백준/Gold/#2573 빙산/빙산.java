import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static int[][] map;
    private static boolean[][] v;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        int count = 0;
        while (true) {
            int[][] newMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    int melting = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0) {
                            melting++;
                        }
                    }

                    int cur = map[i][j];
                    int next = cur - melting;
                    newMap[i][j] = Math.max(next, 0);
                }
            }
            map = newMap;
            count++;

            if (isAllMelt()) {
                break;
            }

            int ice = 0;
            v = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != 0 && !v[i][j]) {
                        dfs(new Point(i, j));
                        ice++;
                    }
                }
            }

            if (ice >= 2) {
                result = count;
                break;
            }
        }
        System.out.println(result);
    }

    private static boolean isAllMelt() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void dfs(Point p) {
        int x = p.x;
        int y = p.y;
        v[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != 0 && !v[nx][ny]) {
                dfs(new Point(nx, ny));
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
