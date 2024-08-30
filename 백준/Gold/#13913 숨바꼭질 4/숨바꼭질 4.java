import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static int n, k, s;
    private static int[] t;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        s = Math.max(n, k) + 2;
        t = new int[s];
        result = new int[s];

        if (n == k) {
            System.out.println(0);
            System.out.println(n);
            return;
        }
        if (n > k) {
            System.out.println(n - k);
            for (int i = n; i >= k; i--) {
                System.out.print(i + " ");
            }
            return;
        }
        bfs();

        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        int tem = result[k];
        stack.push(tem);
        while (tem != n) {
            int tem2 = result[tem];
            stack.push(tem2);
            tem = tem2;
        }
        System.out.println(t[k]);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        t[n] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == k) return;

            int pl = cur + 1;
            int mi = cur - 1;
            int mu = cur * 2;
            if (pl >= 0 && pl < s && t[pl] == 0) {
                q.offer(pl);
                t[pl] = t[cur] + 1;
                result[pl] = cur;
            }
            if (mi >= 0 && mi < s && t[mi] == 0) {
                q.offer(mi);
                t[mi] = t[cur] + 1;
                result[mi] = cur;
            }
            if (mu >= 0 && mu < s && t[mu] == 0) {
                q.offer(mu);
                t[mu] = t[cur] + 1;
                result[mu] = cur;
            }
        }
    }
}