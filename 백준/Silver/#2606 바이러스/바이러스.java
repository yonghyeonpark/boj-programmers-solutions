import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] v;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int com = Integer.parseInt(br.readLine());
        int net = Integer.parseInt(br.readLine());
        v = new boolean[com + 1];

        for (int i = 0; i <= com; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < net; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(1);
        System.out.println(count);
    }

    private static void dfs(int start) {
        v[start] = true;
        for (int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);
            if (!v[next]) {
                count++;
                dfs(next);
            }
        }
    }
}