import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Problem> problems = new PriorityQueue<>((a, b) -> {
            if (a.deadline == b.deadline) {
                return Integer.compare(b.reward, a.reward);
            }
            return Integer.compare(b.deadline, a.deadline);
        });
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int deadline = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());
            problems.offer(new Problem(deadline, reward));
        }

        int result = 0;
        PriorityQueue<Problem> cal = new PriorityQueue<>((a, b) -> Integer.compare(b.reward, a.reward));
        // n일 차부터 1일 차까지 검증
        for (int i = n; i >= 1; i--) {
            while (!problems.isEmpty() && problems.peek().deadline == i) {
                cal.offer(problems.poll());
            }

            if (cal.isEmpty()) continue;
            int reward = cal.poll().reward;
            result += reward;
        }
        System.out.println(result);
    }

    private static class Problem {
        int deadline;
        int reward;

        public Problem(int deadline, int reward) {
            this.deadline = deadline;
            this.reward = reward;
        }
    }
}