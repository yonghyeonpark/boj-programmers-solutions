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

        System.out.println(get(n));
    }

    /*
     * 1. 점화식 활용
     * 2. mod 연산의 성질
     * (a+b) mod c = [(a mod c)+(b mod c)] mod c
     * mod 연산의 결과값을 출력해야 할 때에는 반드시 매 연산마다 mod 연산을 진행해야 한다.
     * 마지막 출력시에만 mod 연산을 진행할 경우, Integer.MAX_VALUE를 넘어 Overflow가 발생하기 때문에 잘못된 값이 출력될 수 있다.
     */
    private static int get(int num) {
        if (dp[num] == 0) {
            dp[num] = (get(num - 1)+ get(num - 2)) % 10007;
        }
        return dp[num];
    }
}