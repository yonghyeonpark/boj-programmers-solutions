import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static Point[] stores;
    private static int sx, sy, ex, ey;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            stores = new Point[n];

            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                stores[j] = new Point(x, y);
            }

            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            System.out.println(bfs(new Point(sx, sy)) ? "happy" : "sad");
        }
    }

    private static boolean bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Point now = q.poll();
            int x = now.x;
            int y = now.y;

            if (Math.abs(x - ex) + Math.abs(y - ey) <= 1000) {
                return true;
            }

            for (Point store : stores) {
                int nx = store.x;
                int ny = store.y;

                if (store.v || Math.abs(x - nx) + Math.abs(y - ny) > 1000) continue;
                store.v = true;
                q.offer(store);
            }
        }
        return false;
    }

    private static class Point {
        int x;
        int y;
        boolean v;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}