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

        Deque<Integer> result = new ArrayDeque<>();
        Deque<Integer> first = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        // 뒤가 바닥
        int[] skills = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            result.offerLast(i);
            skills[i - 1] = Integer.parseInt(st.nextToken());
        }

        // 1: result의 맨앞 카드를 뺀 후, first의 맨앞에 넣음
        // 2: result의 맨앞 카드를 뺀 후, first의 맨앞 카드도 빼고 result에서 빼온 카드를 맨앞에 넣음 (first에서 뺀 카드도 다시 first의 맨앞에 넣음)
        // 3: result의 맨앞 카드를 뺀 후, first의 맨뒤에 넣음
        for (int i = n - 1; i >= 0; i--) {
            int skill = skills[i];
            if (skill == 1) {
                first.offerFirst(result.pollFirst());
            }
            if (skill == 2) {
                int tem = first.pollFirst();
                first.offerFirst(result.pollFirst());
                first.offerFirst(tem);
            }
            if (skill == 3) {
                first.offerLast(result.pollFirst());
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int element : first) {
            sb.append(element)
                    .append(" ");
        }
        System.out.println(sb);
    }
}
