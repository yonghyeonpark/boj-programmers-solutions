import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[][] storage;
    private static List<Tomato> ripeTomatoes;
    private static int n, m, day;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        storage = new int[n][m];

        ripeTomatoes = new ArrayList<>();
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                storage[i][j] = tomato;
                if (tomato == 0) zeroCount++;
                if (tomato == 1) ripeTomatoes.add(new Tomato(i, j));
            }
        }

        if (zeroCount == 0) {
            System.out.println(0);
            return;
        }
        bfs();

        if (isAllRipen()) {
            System.out.println(day);
            return;
        }
        System.out.println(-1);
    }

    private static void bfs() {
        Queue<Tomato> q = new LinkedList<>();
        for (Tomato ripeTomato : ripeTomatoes) {
            q.offer(ripeTomato);
        }

        day = -1;
        while (true) {
            int size = q.size();
            if (size == 0) break;
            day++;

            for (int i = 0; i < size; i++) {
                Tomato cur = q.poll();
                int x = cur.x;
                int y = cur.y;

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || storage[nx][ny] != 0) continue;
                    q.offer(new Tomato(nx, ny));
                    storage[nx][ny] = 1;
                }
            }
        }
    }

    private static boolean isAllRipen() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tomato = storage[i][j];
                if (tomato == 0) return false;
            }
        }
        return true;
    }

    private static class Tomato {
        int x;
        int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}