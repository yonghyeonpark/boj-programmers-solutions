import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        StringBuilder results = new StringBuilder();
        for (int i = 0; i < t; i++) {
            PriorityQueue<Long> pq = new PriorityQueue<>();

            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long result = 0;
            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();

                long sum = a + b;
                pq.offer(sum);
                result += sum;
            }
            results.append(result).append("\n");
        }
        System.out.println(results);
    }
}