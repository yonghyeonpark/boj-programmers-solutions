import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // LinkedHashMap을 사용하면 값을 기준으로 오름차순 정렬 시, 값이 같을 때는 들어온 순서를 유지
        Map<Integer, Integer> message = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            message.put(num, message.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(message.entrySet());
        entryList.sort(Comparator.comparingInt(Map.Entry<Integer, Integer>::getValue).reversed());

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey()).append(" ");
            }
        }
        
        System.out.println(sb);
    }
}
