import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] cost;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int h = Integer.parseInt(br.readLine());
        cost = new int[h][3];
        dp = new int[h][3];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); // 빨강
            cost[i][1] = Integer.parseInt(st.nextToken()); // 초록
            cost[i][2] = Integer.parseInt(st.nextToken()); // 파랑
        }
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        System.out.println(Math.min(get(h - 1, 0), Math.min(get(h - 1, 1), get(h - 1, 2))));
    }

    private static int get(int num, int color) {
        if (dp[num][color] == 0) {
            if (color == 0) {
                dp[num][0] = Math.min(get(num - 1, 1), get(num - 1, 2)) + cost[num][0];
            }
            if (color == 1) {
                dp[num][1] = Math.min(get(num - 1, 0), get(num - 1, 2)) + cost[num][1];
            }
            if (color == 2) {
                dp[num][2] = Math.min(get(num - 1, 0), get(num - 1, 1)) + cost[num][2];
            }
        }
        return dp[num][color];
    }
}