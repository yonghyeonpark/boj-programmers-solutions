import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(Integer.parseInt(br.readLine()));
            return;
        }

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> mQ = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                pQ.offer(num);
                continue;
            }
            mQ.offer(num);
        }

        int sum = 0;
        while (!pQ.isEmpty()) {
            if (pQ.size() == 1) {
                sum += pQ.poll();
                break;
            }
            int f = pQ.poll();
            int s = pQ.poll();

            if (f == 1 || s == 1) {
                sum += f + s;
                continue;
            }
            sum += f * s;
        }
        while (!mQ.isEmpty()) {
            if (mQ.size() == 1) {
                sum += mQ.poll();
                break;
            }
            sum += mQ.poll() * mQ.poll();
        }

        System.out.println(sum);
    }
}
