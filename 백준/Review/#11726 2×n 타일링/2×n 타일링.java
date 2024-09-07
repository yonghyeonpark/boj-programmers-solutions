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
        dp[2] = 2;

        System.out.println(cal(n));
    }

    private static int cal(int num) {
        if (dp[num] == 0) {
            dp[num] = (cal(num - 1) + cal(num - 2)) % 10007;
        }
        return dp[num];
    }
}