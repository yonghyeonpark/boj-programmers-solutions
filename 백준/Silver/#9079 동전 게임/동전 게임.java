import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            map = new int[3][3];
            v = new boolean[512]; // 총 9자리 2진수이기 때문

            for (int j = 0; j < 3; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 3; k++) {
                    String coin = st.nextToken();
                    if (coin.equals("H")) {
                        map[j][k] = 1;
                    } else {
                        map[j][k] = 0;
                    }
                }
            }
            result.append(bfs()).append("\n");
        }
        System.out.println(result);
    }

    private static int bfs() {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(map, 0));
        v[toDecimal(map)] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            int[][] map = cur.map;
            int count = cur.count;

            if (isEnd(map)) return count;

            // 1행
            int[][] tem = getNewMap(map);
            for (int i = 0; i < 3; i++) {
                tem[0][i] = (tem[0][i] == 1) ? 0 : 1;
            }
            if (verify(tem)) {
                q.offer(new State(tem, count + 1));
                v[toDecimal(tem)] = true;
            }

            // 2행
            tem = getNewMap(map);
            for (int i = 0; i < 3; i++) {
                tem[1][i] = (tem[1][i] == 1) ? 0 : 1;
            }
            if (verify(tem)) {
                q.offer(new State(tem, count + 1));
                v[toDecimal(tem)] = true;
            }

            // 3행
            tem = getNewMap(map);
            for (int i = 0; i < 3; i++) {
                tem[2][i] = (tem[2][i] == 1) ? 0 : 1;
            }
            if (verify(tem)) {
                q.offer(new State(tem, count + 1));
                v[toDecimal(tem)] = true;
            }

            // 1열
            tem = getNewMap(map);
            for (int i = 0; i < 3; i++) {
                tem[i][0] = (tem[i][0] == 1) ? 0 : 1;
            }
            if (verify(tem)) {
                q.offer(new State(tem, count + 1));
                v[toDecimal(tem)] = true;
            }

            // 2열
            tem = getNewMap(map);
            for (int i = 0; i < 3; i++) {
                tem[i][1] = (tem[i][1] == 1) ? 0 : 1;
            }
            if (verify(tem)) {
                q.offer(new State(tem, count + 1));
                v[toDecimal(tem)] = true;
            }

            // 3열
            tem = getNewMap(map);
            for (int i = 0; i < 3; i++) {
                tem[i][2] = (tem[i][2] == 1) ? 0 : 1;
            }
            if (verify(tem)) {
                q.offer(new State(tem, count + 1));
                v[toDecimal(tem)] = true;
            }

            // 왼쪽 대각(0,0 / 1,1 / 2,2)
            tem = getNewMap(map);
            for (int i = 0; i < 3; i++) {
                tem[i][i] = (tem[i][i] == 1) ? 0 : 1;
            }
            if (verify(tem)) {
                q.offer(new State(tem, count + 1));
                v[toDecimal(tem)] = true;
            }

            // 오른족 대각(0,2 / 1,1 / 2,0)
            tem = getNewMap(map);
            for (int i = 0; i < 3; i++) {
                tem[i][2 - i] = (tem[i][2 - i] == 1) ? 0 : 1;
            }
            if (verify(tem)) {
                q.offer(new State(tem, count + 1));
                v[toDecimal(tem)] = true;
            }
        }
        return -1;
    }

    private static int[][] getNewMap(int[][] map) {
        int length = map.length;
        int[][] tem = new int[length][];
        for (int i = 0; i < length; i++) {
            tem[i] = map[i].clone();
        }
        return tem;
    }

    private static boolean verify(int[][] map) {
        return !v[toDecimal(map)];
    }

    private static boolean isEnd(int[][] map) {
        int decimal = toDecimal(map);
        return decimal == 0 || decimal == 511;
    }

    private static int toDecimal(int[][] map) {
        StringBuilder bi = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bi.append(map[i][j]);
            }
        }
        return Integer.parseInt(bi.toString(), 2);
    }

    private static class State {
        int[][] map;
        int count;

        public State(int[][] map, int count) {
            this.map = map;
            this.count = count;
        }
    }
}