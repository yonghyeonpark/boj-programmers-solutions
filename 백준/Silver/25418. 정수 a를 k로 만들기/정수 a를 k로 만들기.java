import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;

        while (a < k) {
            if (k % 2 != 0) {
                k -= 1;
                count++;
                if (k == a) {
                    break;
                }
            }
            if (k % 2 == 0 && a * 2 <= k) {
                k /= 2;
                count++;
                if (k == a) {
                    break;
                }
            }
            if (k % 2 == 0 && a * 2 > k) {
                k -= 1;
                count++;
                if (k == a) {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
