import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            count = 0;
            result.append(solution(Integer.parseInt(br.readLine())))
                    .append("\n");
        }

        System.out.println(result);
    }

    private static int solution(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == 1 || now == 0) {
                count++;
                continue;
            }
            if (now >= 3) {
                q.offer(now - 3);
                q.offer(now - 2);
                q.offer(now - 1);
                continue;
            }
            if (now == 2) {
                q.offer(now - 2);
                q.offer(now - 1);
            }
        }
        return count;
    }
}
