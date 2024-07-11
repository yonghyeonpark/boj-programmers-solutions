import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static int[][] map;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int n;
    private static List<Integer> result = new ArrayList<>();
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] ca = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(ca[j]);
            }
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count = 0;
                if (map[i][j] == 0) {
                    continue;
                }
                dfs(i, j);
                total++;
                result.add(count);
            }
        }
        Collections.sort(result);
        System.out.println(total);
        result.forEach(System.out::println);
    }

    private static void dfs(int x, int y) {
        map[x][y] = 0;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == 0) {
                continue;
            }
            dfs(nx, ny);
        }
    }
}