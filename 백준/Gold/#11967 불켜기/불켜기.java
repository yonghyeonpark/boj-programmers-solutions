import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n, result = 1;
    private static int[][] map;
    private static boolean[][] v;
    private static List<Room>[][] switches;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        switches = new List[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                switches[i][j] = new ArrayList<>();
            }
        }
        map = new int[n][n];

        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switches[x - 1][y - 1].add(new Room(a - 1, b - 1));
        }

        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        Queue<Room> q = new LinkedList<>();
        q.offer(new Room(0, 0));
        v = new boolean[n][n];
        v[0][0] = true;
        map[0][0] = 1;

        boolean retry = false;
        while (!q.isEmpty()) {
            Room cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            List<Room> connects = switches[x][y];
            for (Room connect : connects) {
                int cx = connect.x;
                int cy = connect.y;
                if (map[cx][cy] == 0) {
                    map[cx][cy] = 1;
                    result++;
                    retry = true;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (v[nx][ny] || map[nx][ny] == 0) continue;

                q.offer(new Room(nx, ny));
                v[nx][ny] = true;
                map[nx][ny] = 1;
            }
        }

        if (retry) bfs();
    }

    private static class Room {
        int x;
        int y;

        public Room(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}