import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(br.readLine()));
        }

        long result = 0;
        while (pq.size() > 1) {
            long cardA = pq.poll();
            long cardB = pq.poll();

            long sum = cardA + cardB;
            result += sum;
            pq.offer(sum);
        }
        System.out.println(result);
    }
}