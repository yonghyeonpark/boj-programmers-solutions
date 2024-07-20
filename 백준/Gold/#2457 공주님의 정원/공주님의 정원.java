import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static Flower[] flowers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        flowers = new Flower[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            flowers[i] = new Flower(start, end);
        }
        
        Arrays.sort(flowers, (f1, f2) -> {
            if (f1.start == f2.start) return f2.end - f1.end;
            return f1.start - f2.start;
        });
        
        System.out.println(solve());
    }

    private static int solve() {
        int start = 301;
        int end = 1201;
        int tem = 0;
        int result = 0;
        int index = 0;

        while (start < end) {
            boolean b = false;
            for (int i = index; i < n; i++) {
                if (flowers[i].start > start) {
                    break;
                }
                if (flowers[i].end > tem) {
                    index++;
                    tem = flowers[i].end;
                    b = true;
                }
            }

            if (b) {
                start = tem;
                result++;
            } else return 0;
        }
        return result;
    }

    private static class Flower {
        int start;
        int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
