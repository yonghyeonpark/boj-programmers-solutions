import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pQ = new PriorityQueue<>(
                (a, b) -> {
                    int absA = Math.abs(a);
                    int absB = Math.abs(b);
                    if (absA == absB) {
                        return Integer.compare(a, b);
                    }
                    return Integer.compare(absA, absB);
                }
        );

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