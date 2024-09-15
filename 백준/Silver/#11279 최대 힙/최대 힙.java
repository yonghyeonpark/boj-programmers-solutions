import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int e = Integer.parseInt(br.readLine());
            if (e == 0) {
                if (pQ.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(pQ.poll());
                continue;
            }
            pQ.offer(e);
        }
    }
}