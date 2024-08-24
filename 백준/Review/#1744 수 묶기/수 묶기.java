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
            System.out.println(br.readLine());
            return;
        }

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> mQ = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                pQ.add(num);
                continue;
            }
            mQ.add(num);
        }

        int result = 0;
        int pQSize = pQ.size();
        for (int i = 0; i < pQSize; i++) {
            if (i == pQSize - 1) {
                result += pQ.poll();
                break;
            }

            int f = pQ.poll();
            int s = pQ.poll();
            i++;
            if (f == 1 || s == 1) {
                result += f + s;
                continue;
            }
            result += f * s;
        }
        int mQSize = mQ.size();
        for (int i = 0; i < mQSize; i++) {
            if (i == mQSize - 1) {
                result += mQ.poll();
                break;
            }
            result += mQ.poll() * mQ.poll();
            i++;
        }

        System.out.println(result);
    }
}
