import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lines.add(new Line(x, y));
        }
        lines.sort(Comparator.comparing(Line::getX)
                .thenComparing(Line::getY));

        int start = lines.get(0).x;
        int end = lines.get(0).y;
        boolean isLast = true;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            Line line = lines.get(i);
            int x = line.x;
            int y = line.y;

            if (end < x) {
                sum += end - start;
                start = x;
                end = y;
                isLast = false;
                continue;
            }
            if (end < y) {
                end = y;
            }
        }
        if (!isLast || sum == 0) {
            sum += end - start;
        }

        System.out.println(sum);
    }

    private static class Line {
        int x;
        int y;

        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}