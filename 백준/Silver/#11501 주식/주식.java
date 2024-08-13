import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int day = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] dailyPrices = new int[day];
            for (int j = 0; j < day; j++) {
                dailyPrices[j] = Integer.parseInt(st.nextToken());
            }

            int maxPrice = dailyPrices[day - 1];
            long maxProfit = 0;
            for (int j = day - 2; j >= 0; j--) {
                if (maxPrice < dailyPrices[j]) {
                    maxPrice = dailyPrices[j];
                    continue;
                }
                maxProfit += maxPrice - dailyPrices[j];
            }
            sb.append(maxProfit)
                    .append("\n");
        }

        System.out.println(sb);
    }
}