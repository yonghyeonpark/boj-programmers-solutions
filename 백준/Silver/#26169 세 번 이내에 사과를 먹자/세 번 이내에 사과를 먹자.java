import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map = new int[5][5];
    private static int r, c, result = 0;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dfs(new State(r, c, 0, 0));
        System.out.print(result);
    }

    private static void dfs(State s) {
        if (map[s.x][s.y] == 1) {
            s.apple++;
        }
        if (s.moving <= 3 && s.apple >= 2) {
            result = 1;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = s.x + dx[i];
            int ny = s.y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && map[nx][ny] != -1) {
                int tem = map[s.x][s.y];
                map[s.x][s.y] = -1;
                dfs(new State(nx, ny, s.moving + 1, s.apple));
                map[s.x][s.y] = tem; // 다른 분기의 시작을 위해 원래대로 돌려 놓음
            }
        }
    }

    private static class State {
        int x;
        int y;
        int moving;
        int apple;

        public State(int x, int y, int moving, int apple) {
            this.x = x;
            this.y = y;
            this.moving = moving;
            this.apple = apple;
        }
    }
}