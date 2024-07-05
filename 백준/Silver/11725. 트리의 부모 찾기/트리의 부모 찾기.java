import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    private static boolean[] v;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        // 트리 초기화
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        v = new boolean[n+1];
        parent = new int[n+1];

        // 노드 연결
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree.get(x).add(y);
            tree.get(y).add(x);
        }
        find(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void find(int x) {
        if (v[x]) {
            return;
        }
        v[x] = true;
        for (int i = 0; i < tree.get(x).size(); i++) {
            int y = tree.get(x).get(i);
            if (!v[y]) {
                parent[y] = x;
                find(y);
            }
        }
    }
}
