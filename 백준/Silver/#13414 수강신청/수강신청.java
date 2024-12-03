import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= l; i++) {
            String id = br.readLine();

            map.put(id, i);
        }

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(k)
                .forEach(entry -> System.out.println(entry.getKey()));
    }
}