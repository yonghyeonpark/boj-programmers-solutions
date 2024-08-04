import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] stairs;
    private static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int last = Integer.parseInt(br.readLine());
        dp = new Integer[last + 1];
        stairs = new int[last + 1];
        for (int i = 1; i <= last; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stairs[0];
        dp[1] = stairs[1];
        if (last >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        System.out.println(get(last));
    }

    private static int get(int num) {
        if (dp[num] == null) {
            dp[num] = Math.max(get(num - 2), get(num - 3) + stairs[num - 1]) + stairs[num];
        }
        return dp[num];
    }
}