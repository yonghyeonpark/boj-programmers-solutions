import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(a, b);
        }

        Arrays.sort(meetings, (o1, o2) -> {
            if (o1.e == o2.e) {
                return o1.s - o2.s;
            }
            return o1.e - o2.e;
        });

        int count = 0;
        int end = 0;
        for (Meeting meeting : meetings) {
            if (end <= meeting.s) {
                end = meeting.e;
                count++;
            }
        }
        System.out.println(count);
    }

    private static class Meeting {
        int s;
        int e;

        public Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}