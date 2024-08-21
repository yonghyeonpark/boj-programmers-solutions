import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int s = scores[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (s > scores[i]) {
                s = scores[i];
                continue;
            }
            int dif = scores[i] - s + 1;
            count += dif;
            s = scores[i] - dif;
        }

        System.out.println(count);
    }
}
