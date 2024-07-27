import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[][] map;
    private static boolean[] v;
    private static int startCity;
    private static int result = Integer.MAX_VALUE;

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

        for (int i = 0; i < n; i++) {
            v = new boolean[n];
            startCity = i;
            v[i] = true;
            dfs(new State(i, 0, 0));
        }
        System.out.println(result);
    }

    private static void dfs(State state) {
        int city = state.city;
        int cost = state.cost;
        int count = state.count;

        if (count == n - 1) {
            // 시작 도시로 못돌아가는 경우도 조건으로 걸러야함
            if (map[city][startCity] != 0) {
                result = Math.min(result, cost + map[city][startCity]);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (map[city][i] == 0 || v[i]) continue;
            v[i] = true;
            dfs(new State(i, cost + map[city][i], count + 1));
            v[i] = false;
        }
    }

    private static class State {
        int city;
        int cost;
        int count;

        public State(int city, int cost, int count) {
            this.city = city;
            this.cost = cost;
            this.count = count;
        }
    }
}