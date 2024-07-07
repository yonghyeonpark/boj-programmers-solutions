import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static boolean[] v;
    private static int a, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        v = new boolean[k + 1]; // 방문 체크 대상의 크기가 k를 넘을 일이 없음
        bfs(new int[]{a, 0});
    }

    private static void bfs(int[] arr) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(arr);
        
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int num = p[0];
            int count = p[1];

            if (num == k) {
                System.out.print(count);
                break;
            }
            if (num * 2 <= k) {
                v[num * 2] = true;
                q.offer(new int[]{num * 2, count + 1});
            }
            if (!v[num + 1]) {
                q.offer(new int[]{num + 1, count + 1});
            }
        }
    }
}