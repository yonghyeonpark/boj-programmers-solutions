import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<Integer> liA = getSortedList(n);
            List<Integer> liB = getSortedList(m);

            int cur = 0;
            int result = 0;
            for (int j = 0; j < n; j++) {
                int a = liA.get(j);
                for (int k = cur; k < m; k++) {
                    if (liB.get(k) >= a) break;
                    cur = k + 1;
                }
                result += cur;
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static List<Integer> getSortedList(int num) throws IOException {
        List<Integer> li = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < num; j++) {
            li.add(Integer.parseInt(st.nextToken()));
        }
        li.sort(Comparator.naturalOrder());
        return li;
    }
}