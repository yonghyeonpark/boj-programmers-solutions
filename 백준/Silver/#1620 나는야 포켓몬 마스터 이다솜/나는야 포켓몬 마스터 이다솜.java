import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<String> li = new ArrayList<>();
        li.add("empty");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            li.add(name);
            map.put(name, i);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            try {
                result.append(li.get(Integer.parseInt(input))).append("\n");
            } catch (NumberFormatException e) {
                result.append(map.get(input)).append("\n");
            }
        }
        System.out.println(result);
    }
}