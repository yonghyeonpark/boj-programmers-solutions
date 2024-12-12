import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Map<String, List<String>> fashion = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String detail = st.nextToken();
                String type = st.nextToken();

                if (!fashion.containsKey(type)) {
                    fashion.put(type, new ArrayList<>());
                }
                List<String> li = fashion.get(type);
                li.add(detail);
            }

            int sum = 1;
            for (List<String> values : fashion.values()) {
                sum *= (values.size() + 1);
            }
            result.append(sum - 1).append("\n");
        }
        System.out.println(result);
    }
}