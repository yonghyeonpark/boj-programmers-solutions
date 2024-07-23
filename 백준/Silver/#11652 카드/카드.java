import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] cards = new long[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Long.parseLong(br.readLine());
        }

        Map<Long, Long> map = new HashMap<>();
        for (long card : cards) {
            map.put(card, map.getOrDefault(card, 0L) + 1);
        }

        List<Map.Entry<Long, Long>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Comparator.comparingLong(Map.Entry<Long, Long>::getValue).reversed()
                .thenComparingLong(Map.Entry::getKey));

        System.out.println(entryList.get(0).getKey());
    }
}