import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pQ = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pQ.offer(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long x = pQ.poll();
            long y = pQ.poll();
            long sum = x + y;
            pQ.offer(sum);
            pQ.offer(sum);
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += pQ.poll();
        }

        System.out.println(result);
    }
}