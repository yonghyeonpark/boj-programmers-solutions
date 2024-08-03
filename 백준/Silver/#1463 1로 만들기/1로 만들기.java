import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int result;
    private static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        v= new boolean[x];
        calculate(new State(x, 0));

        System.out.println(result);
    }

    private static void calculate(State state) {
        Queue<State> q = new LinkedList<>();
        q.offer(state);

        while (!q.isEmpty()) {
            State now = q.poll();
            int num = now.num;
            int count = now.count;
            if (num == 1) {
                result = count;
                return;
            }

            if (num % 3 == 0 && !v[num / 3]) {
                q.offer(new State(num / 3, count + 1));
                v[num / 3] = true;
            }
            if (num % 2 == 0 && !v[num / 2]) {
                q.offer(new State(num / 2, count + 1));
                v[num / 2] = true;
            }
            q.offer(new State(num - 1, count + 1));
            v[num - 1] = true;
        }
    }

    private static class State {
        int num;
        int count;

        public State(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}