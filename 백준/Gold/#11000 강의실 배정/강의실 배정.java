import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures, Comparator
                .comparingInt(Lecture::getStart)
                .thenComparingInt(Lecture::getEnd)
        );

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        pQ.offer(lectures[0].end);
        for (int i = 1; i < lectures.length; i++) {
            if (lectures[i].start >= pQ.peek()) {
                pQ.poll();
            }
            pQ.offer(lectures[i].end);
        }

        System.out.println(pQ.size());
    }

    private static class Lecture {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}
