import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder result = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            if (command.equals("pop")) {
                int num = -1;
                if (!deque.isEmpty()) num = deque.pollFirst();
                result.append(num).append("\n");
            }
            if (command.equals("size")) {
                result.append(deque.size()).append("\n");
            }
            if (command.equals("empty")) {
                int num = 0;
                if (deque.isEmpty()) num = 1;
                result.append(num).append("\n");
            }
            if (command.equals("front")) {
                int num = -1;
                if (!deque.isEmpty()) num = deque.peekFirst();
                result.append(num).append("\n");
            }
            if (command.equals("back")) {
                int num = -1;
                if (!deque.isEmpty()) num = deque.peekLast();
                result.append(num).append("\n");
            }
        }
        System.out.println(result);
    }
}