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
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(s, e);
        }
        Arrays.sort(
                lectures,
                Comparator.comparingInt(Lecture::getStart)
                        .thenComparingInt(Lecture::getEnd)
        );

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.offer(lectures[0].end);
        for (int i = 1; i < n; i++) {
            Lecture lecture = lectures[i];
            if (lecture.start >= endTimes.peek()) {
                endTimes.poll();
            }
            endTimes.offer(lecture.end);
        }

        System.out.println(endTimes.size());
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
