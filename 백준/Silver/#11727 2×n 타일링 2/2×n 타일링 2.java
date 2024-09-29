import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(1);
            return;
        }
        dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 3;

        System.out.println(recur(n));
    }

    private static int recur(int n) {
        if (dp[n] == 0) {
            dp[n] = (recur(n - 1) + recur(n - 2) * 2) % 10007;
        }
        return dp[n];
    }
}