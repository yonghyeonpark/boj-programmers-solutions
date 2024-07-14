import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static boolean[][] state;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int n, result = Integer.MIN_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                max = Math.max(max, num);
            }
        }

        for (int k = 0; k < max; k++) {
            state = new boolean[n][n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!state[i][j] && map[i][j] > k) {
                        dfs(new Location(i, j, k));
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
        }
        System.out.println(result);
    }

    private static void dfs(Location l) {
        int x = l.x;
        int y = l.y;
        int h = l.h;
        state[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || state[nx][ny] || map[nx][ny] - h <= 0) {
                continue;
            }
            dfs(new Location(nx, ny, h));
        }
    }

    private static class Location {
        int x;
        int y;
        int h;

        public Location(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}