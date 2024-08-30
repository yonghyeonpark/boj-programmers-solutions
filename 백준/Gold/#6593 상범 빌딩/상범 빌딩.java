import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static char[][][] map;
    private static boolean[][][] v;
    private static int z, x, y;
    private static int sz, sx, sy;
    private static int ez, ex, ey;
    private static int[] dx = {0, 0, 1, -1, 0, 0};
    private static int[] dy = {1, -1, 0, 0, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            z = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map = new char[z][x][y];
            v = new boolean[z][x][y];

            if (z == 0 && x == 0 && y == 0) break;

            for (int i = 0; i < z; i++) {
                for (int j = 0; j < x; j++) {
                    char[] charArray = br.readLine().toCharArray();
                    for (int k = 0; k < y; k++) {
                        char c = charArray[k];
                        map[i][j][k] = c;
                        if (c == 'S') {
                            sz = i;
                            sx = j;
                            sy = k;
                        }
                        if (c == 'E') {
                            ez = i;
                            ex = j;
                            ey = k;
                        }
                    }
                }
                br.readLine(); // 빈줄 처리용
            }

            int result = bfs();
            if (result == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + result + " minute(s).");
            }
        }
    }

    private static int bfs() {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(sz, sx, sy, 0));
        v[sz][sx][sy] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            int cz = cur.z;
            int cx = cur.x;
            int cy = cur.y;
            int minute = cur.minute;

            if (cz == ez && cx == ex && cy == ey) return minute;

            for (int i = 0; i < 6; i++) {
                int nz = cz + dz[i];
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nz < 0 || nx < 0 || ny < 0 || nz >= z || nx >= x || ny >= y || v[nz][nx][ny] || map[nz][nx][ny] == '#') continue;
                q.offer(new State(nz, nx, ny, minute + 1));
                v[nz][nx][ny] = true;
            }
        }
        return -1;
    }

    private static class State {
        int z;
        int x;
        int y;
        int minute;

        public State(int z, int x, int y, int minute) {
            this.z = z;
            this.x = x;
            this.y = y;
            this.minute = minute;
        }
    }
}