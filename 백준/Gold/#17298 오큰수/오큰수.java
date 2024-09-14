import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        if (n == 1) {
            System.out.println(-1);
            return;
        }

        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
                seq[stack.pop()] = seq[i];
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            seq[stack.pop()] = -1;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int e : seq) {
            sb.append(e).append(" ");
        }
        System.out.println(sb);
    }
}