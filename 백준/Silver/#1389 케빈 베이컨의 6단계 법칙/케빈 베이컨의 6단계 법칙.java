import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<List<Integer>> relationships = new ArrayList<>();
    private static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i <= n; i++) {
            relationships.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relationships.get(a).add(b);
            relationships.get(b).add(a);
        }

        Map<Integer, Integer> stepValues = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            v = new boolean[n + 1];
            stepValues.put(i, bfs(new State(i, 0)));
        }

        System.out.println(Collections.min(stepValues.entrySet(), Map.Entry.comparingByValue()).getKey());
    }

    private static int bfs(State start) {
        Queue<State> q = new LinkedList<>();
        q.offer(start);
        v[start.person] = true;

        int sum = 0;
        while (!q.isEmpty()) {
            State now = q.poll();
            int person = now.person;
            int step = now.step;

            for (int i = 0; i < relationships.get(person).size(); i++) {
                int next = relationships.get(person).get(i);

                if (v[next]) continue;
                q.offer(new State(next, step + 1));
                v[next] = true;
                sum += step + 1;
            }
        }
        return sum;
    }

    private static class State {
        int person;
        int step;

        public State(int person, int step) {
            this.person = person;
            this.step = step;
        }
    }
}
