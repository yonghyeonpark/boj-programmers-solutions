import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static char[][] map;
    private static boolean[][] v;
    private static List<Fire> fires;
    private static int n, m, sx, sy;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new char[m][n];
            v = new boolean[m][n];
            fires = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                char[] charArray = br.readLine().toCharArray();
                for (int k = 0; k < n; k++) {
                    char c = charArray[k];
                    map[j][k] = c;
                    if (c == '@') {
                        sx = j;
                        sy = k;
                    }
                    if (c == '*') {
                        fires.add(new Fire(j, k));
                    }
                }
            }
            
            int result = bfs();
            if (result == -1) {
                sb.append("IMPOSSIBLE").append("\n");
            } else sb.append(result + 1).append("\n");
        }
        
        System.out.println(sb);
    }

    /*
     * 1. 불 번짐 반영
     * 2. 상근이 이동
     */
    private static int bfs() {
        Queue<Fire> f = new LinkedList<>();
        for (Fire fire : fires) {
            f.offer(fire);
            v[fire.x][fire.y] = true; // 보류
        }
        Queue<State> p = new LinkedList<>();
        p.offer(new State(sx, sy, 0));
        v[sx][sy] = true;

        // 상근이의 위치가 들어있는 큐가 while 문 종료 기준
        while (!p.isEmpty()) {
            int sizeF = f.size();
            for (int i = 0; i < sizeF; i++) {
                Fire curF = f.poll();
                int fx = curF.x;
                int fy = curF.y;

                for (int j = 0; j < 4; j++) {
                    int nx = fx + dx[j];
                    int ny = fy + dy[j];

                    if (nx < 0 || ny < 0 || nx >= m || ny >= n || map[nx][ny] == '#' || map[nx][ny] == '*') continue;
                    f.offer(new Fire(nx, ny));
                    map[nx][ny] = '*';
                }
            }

            int sizeP = p.size();
            for (int i = 0; i < sizeP; i++) {
                State curP = p.poll();
                int px = curP.x;
                int py = curP.y;
                int count = curP.count;

                if (px == 0 || py == 0 || px == m - 1 || py == n - 1) return count;

                for (int j = 0; j < 4; j++) {
                    int nx = px + dx[j];
                    int ny = py + dy[j];

                    if (nx < 0 || ny < 0 || nx >= m || ny >= n || map[nx][ny] != '.' || v[nx][ny]) continue;
                    p.offer(new State(nx, ny, count + 1));
                    v[nx][ny] = true;
                }
            }
        }
        return -1;
    }

    private static class Fire {
        int x;
        int y;

        public Fire(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class State {
        int x;
        int y;
        int count;

        public State(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}