import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 답은 부호있는 64bit 정수형으로 표현 가능
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            List<Integer> prices = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                prices.add(Integer.parseInt(st.nextToken()));
            }

            int size = prices.size();
            int std = prices.get(size - 1);
            long result = 0;
            for (int j = size - 2; j >= 0; j--) {
                int price = prices.get(j);
                if (price < std) {
                    result += std - price;
                    continue;
                }
                std = price;
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
