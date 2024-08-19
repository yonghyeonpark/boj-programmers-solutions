import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n;
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] v;
    private static Map<Integer, Integer> result = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            v = new boolean[n + 1];
            bfs(new State(i, 0));
        }

        int minScore = Collections.min(result.entrySet(), Map.Entry.comparingByValue()).getValue();
        int memberCount = 0;
        List<Integer> candidates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (entry.getValue() == minScore) {
                memberCount++;
                candidates.add(entry.getKey());
            }
        }

        System.out.println(minScore + " " + memberCount);
        Collections.sort(candidates);
        for (int candidate : candidates) {
            System.out.print(candidate + " ");
        }
    }

    private static void bfs(State start) {
        Queue<State> q = new LinkedList<>();
        q.offer(start);
        v[start.x] = true;

        int score = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            State now = q.poll();
            int x = now.x;
            int count = now.count;

            for (int i = 0; i < graph.get(x).size(); i++) {
                int next = graph.get(x).get(i);
                if (v[next]) {
                    score = Math.max(score, count);
                    continue;
                }
                q.offer(new State(next, count + 1));
                v[next] = true;
            }
        }
        result.put(start.x, score);
    }

    private static class State {
        int x;
        int count;

        public State(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
}
