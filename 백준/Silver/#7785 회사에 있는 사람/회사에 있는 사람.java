import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<String, String> state = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            state.put(st.nextToken(), st.nextToken());
        }

        List<String> remain = new ArrayList<>();
        for (Map.Entry<String, String> entry : state.entrySet()) {
            if (entry.getValue().equals("leave")) continue;
            remain.add(entry.getKey());
        }

        remain.sort(Comparator.reverseOrder());
        StringBuilder result = new StringBuilder();
        for (String person : remain) {
            result.append(person).append("\n");
        }
        System.out.println(result);
    }
}