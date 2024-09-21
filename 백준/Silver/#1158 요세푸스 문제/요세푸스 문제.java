import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int k = Integer.parseInt(st.nextToken());
        StringBuilder result = new StringBuilder();
        result.append("<");
        while (!q.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                if (q.isEmpty()) continue;
                q.offer(q.poll());
            }
            result.append(q.poll());
            if (!q.isEmpty()) result.append(", ");
        }
        result.append(">");
        System.out.println(result);
    }
}